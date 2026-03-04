import pygame
import os
import random
import csv

pygame.init()  #initializing pygame


###Setting Game window:
SCREEN_WIDTH = 800
SCREEN_HEIGHT = int(SCREEN_WIDTH*0.8)

##Creating game window:
screen = pygame.display.set_mode((SCREEN_WIDTH, SCREEN_HEIGHT))
pygame.display.set_caption('MarTra') #This will set the caption on our game window

##Set frame rate
clock=pygame.time .Clock()
FPS=60

#define game variables
GRAVITY=0.75
ROWS=16 #this is fixed in the loaded csv file
COLS=150 #this is fixed in the loaded csv file
TILE_SIZE=SCREEN_HEIGHT//ROWS
TILE_TYPES = 21 # it is also fixed as we have used 21 types of tile
level=1

#Definig the player action variables
moving_left= False
moving_right= False
shoot=False
grenade=False
grenade_thrown=False 	

##load images
#store tiles in a list
img_list=[]
for x in range(TILE_TYPES):
	img=pygame.image.load(f'img/Tile/{x}.png')
	img=pygame.transform.scale(img,(TILE_SIZE,TILE_SIZE)) #arguments: (who,(width, height))
	img_list.append(img)
#bullet
bullet_img=pygame.image.load('img/icons/bullet.png').convert_alpha() # (ref. FunGuide for "convert_alpha()")
#grenade
grenade_img=pygame.image.load('img/icons/grenade.png').convert_alpha()
#pick up boxes
health_box_img=pygame.image.load('img/icons/health_box.png').convert_alpha()
ammo_box_img=pygame.image.load('img/icons/ammo_box.png').convert_alpha()
grenade_box_img=pygame.image.load('img/icons/grenade_box.png').convert_alpha()
item_boxes={'Health':health_box_img, 'Ammo':ammo_box_img,'Grenade':grenade_box_img} #Creating a dictionary



#Defining the colours:
BG=(144,201,120)
RED=(255,0,0)
WHITE=(255,255,255)
GREEN=(0,255,0)
BLACK=(0,0,0)

#define font
font = pygame.font.SysFont('Futura',30) #defining the type of fomnt and its size

def draw_text(text, font, text_col, x, y):
	img=font.render(text, True, text_col) #this will rend up the text into the image as pygame has no option to display the text directly on the screen
	screen.blit(img, (x,y)) #show the text image on the screen

def draw_bg():#This method will help to give the background and referesh
	screen.fill(BG)
	# pygame.draw.line(screen, RED, (0,300), (SCREEN_WIDTH,300))#to give a temporary line as a base on the screen it takes 4 arguments, 1st the on which window, 2nd the colour of line, 3rd is start coordinates, 4th end coordinates

##Setting the player:
class Soldier(pygame.sprite.Sprite): #it gives extra functionality related to pygame and is called sprite class(ref. FunGuide)
	def __init__(self, char_type, x, y, scale, speed, ammo, grenades): 
		"""this method will give the player its type, scale, position, structure and speed 
		(speed means how many pixels the image will move when pressing the assigned movement key)"""
		pygame.sprite.Sprite.__init__(self)
		self.alive=True
		self.char_type=char_type
		self.speed=speed
		self.ammo=ammo
		self.Start_ammo=ammo
		self.shoot_cooldown=0
		self.grenades=grenades
		self.health=100
		self.max_health=self.health
		self.direction=1 #For deciding the direction of the player that it is moving in which direction
		self.vel_y=0
		self.jump= False #For jumping of the player
		self.in_air= True #Check for the player that is it in air or not
		self.flip=False #for flipping the image of player if moving reverse
		self.animation_list=[] #for switching between the images to show the amination in jump, walk, etc.
		self.frame_index=0 #starting index for the animation
		self.action=0 #this will check for which action is being perform
		self.update_time=pygame.time.get_ticks()
		#create ai specific variables
		self.move_counter=0 
		self.vision=pygame.Rect(0,0,150,20) #argument: (x,y,width,height)
		self.idling= False
		self.idling_counter= 0

		#load all images for the players
		animation_types=['Idle', 'Run', 'Jump', 'Death']#Name of the folders in which we have stored the images
		for animation in animation_types:
			#Reset temporary list of images
			temp_list=[]
			#Count number of files in the folder
			num_of_frames = len(os.listdir(f'img/{self.char_type}/{animation}')) #"listdir()" of "os" module makes list of items in a folder

			for i in range(num_of_frames):
				img= pygame.image.load(f'img/{self.char_type}/{animation}/{i}.png').convert_alpha() #Loads the player image
				img = pygame.transform.scale(img, (int(img.get_width()* scale), int(img.get_height() * scale))) #This will scale(resize) the image 
				temp_list.append(img)
			self.animation_list.append(temp_list)
		
		self.image=self.animation_list[self.action][self.frame_index]
		self.rect = self.image.get_rect() #This will treat our image as the rectangle
		self.rect.center=(x,y)
		self.width=self.image.get_width()
		self.height=self.image.get_height()

	def update(self):
		self.update_animation()
		self.check_alive( )
		#update cooldown
		if self.shoot_cooldown>0:
			self.shoot_cooldown -= 1


	def move(self, moving_left, moving_right):#will give the movement to the soliders(images of the soldier)
		#reset movement variables
		dx=0
		dy=0
		#assign movement variables if moving left or right
		if moving_left:
			dx= -self.speed
			self.flip= True
			self.direction=-1 
		if moving_right:
			dx= self.speed
			self.flip= False
			self.direction=1
		
		##jump
		if self.jump == True and self.in_air==False: #"self.in_air==False" to stop the player to double jump
			self.vel_y= -12 #-ve because y axis becomes -ve above origin and positive below the origin
			self.jump=False
			self.in_air=True
		#apply gravity
		self.vel_y+=GRAVITY
		if self.vel_y>10:
			self.vel_y
		dy+=self.vel_y
		#check for  collision
		for tile in world.obstacle_list: #check for collision with obstacles and not allow to pass through
			#check for collision in x direction
			if tile[1].colliderect(self.rect.x + dx, self.rect.y, self.rect.width, self.rect.height): #"tile" stores image at index "0" and rectangle at index "1"
				dx=0 #stop the player to move in x if collision
			#check for collision in y direction
			if tile[1].colliderect(self.rect.x, self.rect.y + dy, self.rect.width, self.rect.height): 
				#check if below the ground, i.e. jumping
				if self.vel_y < 0: #it means player is jumping, since -ve "vel_y" shows jump
					self.vel_y=0 #to stop the player to move up after colliding with the ceiling
					dy= tile[1].bottom - self.rect.top 
				#check if above the ground, i.e. falling
				elif self.vel_y >=0: #it means player is falling, since +ve "vel_y" shows fall
					self.vel_y=0 #to stop the player to move down after colliding with the floor
					self.in_air=False #to set the player on the floor after colliding with the floor
					dy= tile[1].top - self.rect.bottom 

		#updating rectangle position
		self.rect.x+=dx
		self.rect.y+=dy 

	def shoot(self):
		if self.shoot_cooldown == 0 and self.ammo>0:
			self.shoot_cooldown =20
			bullet= Bullet(self.rect.centerx + (0.75*self.rect.size[0]*self.direction),self.rect.centery, self.direction) 
			#creating the instance of bullet class. "player.rect.size[0]" gives the size of the rectangle and "size[0]" means x size(width)
			bullet_group.add(bullet) 
			#reduce ammo
			self.ammo -= 1

	def ai(self):
		if self.alive and player.alive:
			#idle state
			if self.idling == False and random.randint(1,200) == 1:
				self.update_action(0) #to turn the animation to the idle standing state as "0" means idle
				self.idling= True
				self.idling_counter = 100
			#check if the ai is near the player
			if self.vision.colliderect(player.rect): #"yadi vision rectangle collide hota hai player ke rectangle se"
				#stop running and face the player
				self.update_action(0) #action update kardo 0 par as 0 means idel/standing 
				#shoot
				self.shoot()

			else:
				#non-odle state
				if self.idling == False:
					if self.direction==1:
						ai_moving_right=True
					else:
						ai_moving_right=False
					ai_moving_left= not ai_moving_right
					self.move(ai_moving_left, ai_moving_right)
					self.update_action(1) #animating the enemy ai for running as "1" means running
					self.move_counter += 1
					#Update ai vision as the enemy moves
					self.vision.center=(self.rect.centerx + 75 * self.direction, self.rect.centery) #"+75" because we have given width 150 to the vision rectangle and "centerx"
					# pygame.draw.rect(screen, RED, self.vision)                    

					if self.move_counter > TILE_SIZE:
						self.direction *= -1
						self.move_counter *= -1
				else:
					self.idling_counter -= 1
					if self.idling_counter <= 0:
						self.idling = False  


	def update_animation(self):
		#Update animation
		ANIMATION_COOLDOWN=100 #it is in miliseconds
		#Update image depending on current frame
		self.image=self.animation_list[self.action][self.frame_index]
		#check if enough time has passed since the last update
		if pygame.time.get_ticks()-self.update_time> ANIMATION_COOLDOWN:
			self.update_time=pygame.time.get_ticks() #to update the update time in each iteration
			self.frame_index+=1
		#if animation has run out, the reset back to the start
		if self.frame_index>=len(self.animation_list[self.action]):
			if self.action == 3: #action index 3 is for death
				self.frame_index=len(self.animation_list[self.action])-1 #It will give the last animation
			else:
				self.frame_index=0

	def update_action(self, new_action): #this will alter between the actions and the animations for actions
		#check if the new action is different to the previous one
		if new_action!=self.action:
			self.action=new_action
			#update the animation settings
			self.frame_index=0
			self.update_time=pygame.time.get_ticks()

	def check_alive(self):
		if self.health <= 0:
			self.health=0
			self.speed=0
			self.alive=False
			self.update_action(3)


	def draw(self): #This method will draw the Soldier on the screen using "blit" function (ref. FunGuide)
		screen.blit(pygame.transform.flip(self.image, self.flip, False), self.rect) 
		"""'screen' is the window we created, "img" has image, "rect" contains coordinates. here
		   'pygame.transform.flip' will help us in flipping the image when the player will move left side.
		   It takes 3 arguments, 1st for which image, 2nd for flip in x axis, and 3rd to flip in y axis"""
		# pygame.draw.rect(screen, RED, self.rect, 1) # to draw rectangle around. arguments=(where, colour, who, border)


class World():
	def __init__(self):
		self.obstacle_list = [] #this will contain the tiles which will be solid and will not allow soldier to pass through

	def process_data(self,data):
		#iterate through each value in level data file 
		for y, row in enumerate(data): #(ref. FunGuide for enumerate())
			for x, tile in enumerate(row):
				if tile >= 0: #this will ignore -1 as "-1" means blank in the csv file
					img = img_list[tile]
					img_rect=img.get_rect()
					img_rect.x= x * TILE_SIZE
					img_rect.y= y * TILE_SIZE
					tile_data=(img, img_rect) #its a tuple
					if tile >= 0 and tile <= 8: #obstacles/land (stop player to move through)
						self.obstacle_list.append(tile_data)
					elif tile >= 9 and tile <= 10: #create water
						decoration = Decoration(img , x * TILE_SIZE, y * TILE_SIZE)
						decoration_group.add(decoration)
					elif tile >= 11 and tile <= 14: #create decoration
						water = Water(img , x * TILE_SIZE, y * TILE_SIZE)
						water_group.add(water)
					elif tile == 15: #create player
						player= Soldier('player', x * TILE_SIZE, y * TILE_SIZE, 1.65, 5, 20, 10)
						health_bar=HealthBar(10,10,player.health, player.health)
					elif tile == 16: #create enemy
						enemy= Soldier('enemy', x * TILE_SIZE, y * TILE_SIZE, 1.65, 2.5, 20, 0)
						enemy_group.add(enemy) 
					elif tile == 17: #create ammo box
						item_box = ItemBox('Ammo', x * TILE_SIZE, y * TILE_SIZE)
						item_box_group.add(item_box)
					elif tile == 18: #create grenade box
						item_box = ItemBox('Grenade', x * TILE_SIZE, y * TILE_SIZE)
						item_box_group.add(item_box)
					elif tile == 19: #create health box
						item_box = ItemBox('Health', x * TILE_SIZE, y * TILE_SIZE)
						item_box_group.add(item_box)
					elif tile == 20: #create exit
						exit = Exit(img , x * TILE_SIZE, y * TILE_SIZE)
						exit_group.add(exit)
		return player,health_bar

	def draw(self):
		for tile in self.obstacle_list:
			screen.blit(tile[0], tile[1]) #{not understand} 


class Decoration(pygame.sprite.Sprite):
	def __init__(self, img, x, y):
		pygame.sprite.Sprite.__init__(self)
		self.image = img
		self.rect = self.image.get_rect()
		self.rect.midtop = (x + TILE_SIZE // 2, y + (TILE_SIZE-self.image.get_height()))


class Water(pygame.sprite.Sprite):
	def __init__(self, img, x, y):
		pygame.sprite.Sprite.__init__(self)
		self.image = img
		self.rect = self.image.get_rect()
		self.rect.midtop = (x + TILE_SIZE // 2, y + (TILE_SIZE-self.image.get_height()))


class Exit(pygame.sprite.Sprite):
	def __init__(self, img, x, y):
		pygame.sprite.Sprite.__init__(self)
		self.image = img
		self.rect = self.image.get_rect()
		self.rect.midtop = (x + TILE_SIZE // 2, y + (TILE_SIZE-self.image.get_height()))



class ItemBox(pygame.sprite.Sprite):
	def __init__(self, item_type, x, y):
		pygame.sprite.Sprite.__init__(self)
		self.item_type=item_type #since we have made a dictionary in the start for the item_boxes, and the key will feed the "item_type" here
		self.image=item_boxes[self.item_type] #the key from the dictionary will feed in the string here
		self.rect= self.image.get_rect()
		self.rect.midtop=(x+TILE_SIZE//2, y+(TILE_SIZE-self.image.get_height()))

	def update(self):
		#check if the player has picked up the box
		if pygame.sprite.collide_rect(self, player):
			#check what kind of box it was
			if self.item_type=='Health':
				player.health += 50
				if player.health > player.max_health:
					player.health=player.max_health
			elif self.item_type=='Ammo':
				player.ammo += 10
			elif self.item_type=='Grenade':
				player.grenades += 5
			#delete the item box
			self.kill()


class HealthBar():
	def __init__(self,x,y,health,max_health):
		self.x=x
		self.y=y
		self.health=health
		self.max_health=max_health         

	def draw(self, health):
		#update with new health
		self.health=health

		#calculate health ratio
		ratio = self.health/self.max_health #this ratio will work as the area cover for the green colour showing the health in the health bar
		pygame.draw.rect(screen, BLACK, (self.x - 2, self.y - 2, 154, 24))
		pygame.draw.rect(screen, RED, (self.x, self.y, 150, 20)) #it will work as base. arguments: (where, colour,(x, y, weidth, height))
		pygame.draw.rect(screen, GREEN, (self.x, self.y, 150 * ratio, 20)) #it will be the actual health which will be decreasing


class Bullet(pygame.sprite.Sprite):
	def __init__(self, x, y, direction):
		pygame.sprite.Sprite.__init__(self)
		self.speed=10
		self.image= bullet_img
		self.rect=self.image.get_rect()
		self.rect.center=(x, y)
		self.direction=direction #this "direction" is same as of the player's

	def update(self):
		#move bullet
		self.rect.x+=(self.direction*self.speed)
		#check if bullet has gone off screen
		if self.rect.right<0 or self.rect.left>SCREEN_WIDTH:
			self.kill()  
		#check collision with level
		for tile in world.obstacle_list:
			if tile[1].colliderect(self.rect):
				self.kill()
		#check collision with characters
		if pygame.sprite.spritecollide(player, bullet_group, False):
		#pygame.sprite.spritecollide()" checks for collision. arguments, 1st whome to collide, 2nd group, 3rd that you want to be deleted after collision
			if player.alive:
				player.health -= 5
				self.kill() #it will kill(delete) the bullet
		for enemy in enemy_group:	
			if pygame.sprite.spritecollide(enemy, bullet_group, False):
				if enemy.alive:
					enemy.health -= 25
					# print(enemy.health)
					self.kill()


class Grenade(pygame.sprite.Sprite):
	def __init__(self, x, y, direction):
		pygame.sprite.Sprite.__init__(self)
		self.timer = 100
		self.vel_y = -11#Verticle velocity for the grenade
		self.speed= 7#Horizontal velocity
		self.image= grenade_img
		self.rect=self.image.get_rect()
		self.rect.center=(x, y)
		self.width= self.image.get_width()
		self.height= self.image.get_height()
		self.direction=direction #this "direction" is same as of the player's

	def update(self):
		self.vel_y += GRAVITY
		dx= self.direction * self.speed
		dy= self.vel_y

		#check for collision with level
		for tile in world.obstacle_list:
			#check collision with walls
			if tile[1].colliderect(self.rect.x + dx, self.rect.y, self.width, self.height):
				self.direction *= -1
				dx= self.direction * self.speed
			#check for collision in y direction
			if tile[1].colliderect(self.rect.x, self.rect.y + dy, self.rect.width, self.rect.height): 
				self.speed = 0 #otherwise the grenade will keep sliding untill blown
				#check if below the ground, i.e. thrown up
				if self.vel_y < 0: 
					self.vel_y=0
					dy= tile[1].bottom - self.rect.top 
				#check if above the ground, i.e. throw down
				elif self.vel_y >=0: 
					self.vel_y=0 
					dy= tile[1].top - self.rect.bottom 
			

		#update grenade position
		self.rect.x += dx
		self.rect.y += dy  
		#countdown timer
		self. timer -= 1
		if self.timer <= 0:
			self.kill()
			explosion= Explosion(self.rect.x, self.rect.y, 0.5)
			explosion_group.add(explosion)
			#do damage to anyone that is nearby
			if abs(self.rect.centerx - player.rect.centerx) < TILE_SIZE*2 and \
				abs(self.rect.centery - player.rect.centery) < TILE_SIZE*2:
				player.health -= 25
			for enemy in enemy_group:
				if abs(self.rect.centerx - enemy.rect.centerx) < TILE_SIZE*2 and \
					abs(self.rect.centery - enemy.rect.centery) < TILE_SIZE*2:
					enemy.health -= 50



class Explosion(pygame.sprite.Sprite):
	def __init__(self, x, y, scale):
		pygame.sprite.Sprite.__init__(self)
		self.images=[]
		for num in range(1,6): #since, there are siz images in the explosion's image folder
			img=pygame.image.load(f'img/explosion/exp{num}.png').convert_alpha()
			img=pygame.transform.scale(img, (int(img.get_width()*scale), int(img.get_height() * scale)))
			self.images.append(img)
		self.frame_index=0
		self.image = self.images[self.frame_index]
		self.rect=self.image.get_rect()
		self.rect.center=(x, y)
		self.counter=0 #this will control the animation

	def update(self):
		EXPLOSION_SPEED=4 #cooldown for explosion
		#update explosion animation
		self.counter += 1
		if self.counter >= EXPLOSION_SPEED:
			self.counter = 0 #reset the counter
			self. frame_index += 1 #to change the index images in the list
			#if the animation is complete then delete the explosion
			if self.frame_index >= len(self.images):
				self.kill()
			else:
				self.image = self.images[self.frame_index] # to change the images
		
		

#create sprite groups
enemy_group=pygame.sprite.Group()
bullet_group=pygame.sprite.Group()
grenade_group=pygame.sprite.Group()
explosion_group=pygame.sprite.Group()
item_box_group=pygame.sprite.Group()
decoration_group=pygame.sprite.Group()
water_group=pygame.sprite.Group()
exit_group=pygame.sprite.Group()


# #temp - create item boxes
# item_box = ItemBox('Health', 100, 260)
# item_box_group.add(item_box)
# item_box = ItemBox('Ammo', 400, 260)
# item_box_group.add(item_box)
# item_box = ItemBox('Grenade', 500, 260)
# item_box_group.add(item_box)

# player= Soldier('player',200,200,1.65,5,20,10)
# health_bar=HealthBar(10,10,player.health, player.health)

# enemy= Soldier('enemy', 500,200,1.65,2.5,20,0)
# enemy2= Soldier('enemy', 300,200,1.65,2.5,20,0)
# enemy_group.add(enemy)
# enemy_group.add(enemy2)
#commenting the above code because we have used the csv file for the world and that file contains the soldiers and we can add or remove the soldiers for that file directly

#create empty tile list
world_data = []
for row in range(ROWS): #iterate for 16 times
	r = [-1]*COLS #a list of 150 -1s as columns
	world_data.append(r)
#load in level data and create world
with open(f'level{level}_data.csv', newline='')as csvfile:
	reader = csv.reader(csvfile, delimiter=',') #"delimiter" is a term in csv file which separates the terms
	for x, row in enumerate(reader):
		for y, tile in enumerate(row):
			world_data[x][y] = int(tile)
world = World()
player, health_bar = world.process_data(world_data)


##Keeping the window continue to be on screen:
run = True
while run:

	#Controlling the player image movement's FPS on the screen:
	clock.tick(FPS)

	#Update background
	draw_bg()

	#draw world map
	world.draw()
	

	# show health screen
	health_bar.draw(player.health)
	#show no. of ammo screen
	draw_text("AMMO:",font,WHITE,10,35)
	for x in range(player.ammo):
		screen.blit(bullet_img,(90 + (x*10), 35))
	#show no. of grenades screen
	draw_text("GRENADES:",font,WHITE,10,55)
	for x in range(player.grenades):
		screen.blit(grenade_img,(140 + (x*15), 55))
	


	#Giving the animations to the image(by swapping multiple images)
	player.update()

	#Drawing the player image on the screen:
	player.draw()

	for enemy in enemy_group:
		#Update the actions of enemy
		enemy.update()
		
		#Drawing the enemy image on the screen:
		enemy.draw()

		#Applying AI to the enemy
		enemy.ai()

	#Update and draw gropus
	bullet_group.update()
	grenade_group.update()
	explosion_group.update()
	item_box_group.update()
	decoration_group.update()
	water_group.update()
	exit_group.update()
	bullet_group.draw(screen)
	grenade_group.draw(screen)
	explosion_group.draw(screen)
	item_box_group.draw(screen)
	decoration_group.draw(screen)
	water_group.draw(screen)
	exit_group.draw(screen)

	
	#update player actions
	if player.alive:
		#shoot bullets
		if shoot:
			player.shoot()
		#throw grenades 
		elif grenade and grenade_thrown==False and player.grenades>0:
			grenade=Grenade(player.rect.centerx+(0.5 * player.rect.size[0] * player.direction),\
					player.rect.top, player.direction) #you can split the single line by "\"+enter
			grenade_group.add(grenade)
			#Reduce grenades
			player.grenades -= 1
			grenade_thrown=True
			# print(player.grenades)
		if player.in_air:
			player.update_action(2)#2 means jump
		elif moving_left or moving_right:
			player.update_action(1)# 1 means run
		else:
			player.update_action(0)# 0 means idle
	
	#Moving the player image on the screen:
	player.move(moving_left,moving_right)

	for event in pygame.event.get():
		#quit game
		if event.type == pygame.QUIT: #to quit the game
			run = False
		
		#Keyboard presses
		if event.type == pygame.KEYDOWN:
			if event.key==pygame.K_a:
				moving_left=True
			if event.key==pygame.K_d:
				moving_right=True
			if event.key==pygame.K_SPACE:
				shoot=True
			if event.key==pygame.K_q:
				grenade=True
			if event.key==pygame.K_w and player.alive:
				player.jump=True
			if event.key==pygame.K_ESCAPE:
				run=False #"run" is the variable we have created to keep our gaming window running	
		#Keyboard button releases
		if event.type == pygame.KEYUP:
			if event.key==pygame.K_a:
				moving_left=False
			if event.key==pygame.K_d:
				moving_right=False
			if event.key==pygame.K_SPACE:
				shoot=False
			if event.key==pygame.K_q:
				grenade=False
				grenade_thrown=False

	pygame.display.update() #It updates the contents of the display surface to the screen

pygame.quit()


