import matplotlib.pyplot as plt

##Line plot
# Data points
x = [1, 2, 3, 4, 5]
y = [2, 4, 6, 8, 10]

# Generate line plot
plt.plot(x, y, color='blue', linestyle='--', marker='o')

# Add metadata labels
plt.title("Simple Line Plot")
plt.xlabel("X Axis Label")
plt.ylabel("Y Axis Label")

# Render graph
plt.show()

#----------------------------------------------------------------

##Bar chart
# Categorical data
categories = ['Apples', 'Bananas', 'Cherries', 'Dates']
quantities = [15, 22, 8, 12]

# Generate bar chart
plt.bar(categories, quantities, color='green')

# Add metadata labels
plt.title("Fruit Inventory")
plt.xlabel("Fruit Type")
plt.ylabel("Quantity Sold")

# Render graph
plt.show()

#----------------------------------------

##Scatter plot
# Coordinate data
x_coords = [5, 7, 8, 7, 2, 17, 2, 9, 4, 11]
y_coords = [99, 86, 87, 88, 111, 86, 103, 87, 94, 78]

# Generate scatter plot
plt.scatter(x_coords, y_coords, color='red', alpha=0.7)

# Add metadata labels
plt.title("Vehicle Age vs. Top Speed")
plt.xlabel("Age of Car (Years)")
plt.ylabel("Top Speed (MPH)")

# Render graph
plt.show()

#------------------------------------------------------

##Histogram
import numpy as np

# Generate random distribution data
data = np.random.normal(170, 10, 250)

# Generate histogram distribution
plt.hist(data, bins=15, color='purple', edgecolor='black')

# Add metadata labels
plt.title("Height Distribution")
plt.xlabel("Height (cm)")
plt.ylabel("Number of People")

# Render graph
plt.show()

#------------------------------------------------

##Multi plot figure
# Setup grid matrix (1 row, 2 columns)
fig, (ax1, ax2) = plt.subplots(1, 2, figsize=(10, 4))

# Populate Left Plot
ax1.plot([1, 2, 3], [3, 2, 1], color='orange')
ax1.set_title("First Subplot (Line)")

# Populate Right Plot
ax2.scatter([1, 2, 3], [1, 2, 3], color='teal')
ax2.set_title("Second Subplot (Scatter)")

# Render final window canvas
plt.tight_layout()
plt.show()
