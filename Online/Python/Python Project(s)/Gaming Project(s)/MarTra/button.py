import pygame

#button class
class Button():
    def __init__(self,x,y,image,scale):
        width = image.get_width()
        height = image.get_height()
        self.image = pygame.transform.scale(image,(int(width * scale),int(height * scale)))
        self.rect = self.image.get_rect() #to get the rectangle of the button
        self.rect.topleft = (x,y) #to set the position of the button
        self.clicked = False #to check if the button is clicked or not

    def draw(self, surface):
        action=False

        #get mouse position
        pos = pygame.mouse.get_pos()

        #check mouseover and clicked  conditions
        if self.rect.collidepoint(pos):
            if pygame.mouse.get_pressed()[0] == 1 and self.clicked == False: #to check if the left mouse button is pressed and the button is not already clicked
                action = True
                self.clicked = True

        if pygame.mouse.get_pressed()[0] == 0: #to check if the left mouse button is released
            self.clicked = False

        #draw button
        surface.blit(self.image,(self.rect.x,self.rect.y)) #to draw the button on the surface

        return action