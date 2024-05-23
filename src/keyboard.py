import pygame
import sys

# Initialize Pygame
pygame.init()

# Set up screen dimensions
SCREEN_WIDTH, SCREEN_HEIGHT = 800, 600
screen = pygame.display.set_mode((SCREEN_WIDTH, SCREEN_HEIGHT))
pygame.display.set_caption("On-Screen Keyboard")

# Set up colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
GREEN = (0, 255, 0)

# Set up joystick
pygame.joystick.init()
if pygame.joystick.get_count() > 0:
    joystick = pygame.joystick.Joystick(0)
    joystick.init()
else:
    print("No joystick detected.")
    sys.exit()

# Define keyboard layout
keyboard_layout = [
    ['q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'],
    ['a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'],
    ['z', 'x', 'c', 'v', 'b', 'n', 'm'],
    ['SPACE', 'BACK', 'ENTER']
]

# Set up font
font = pygame.font.Font(None, 36)

# Function to draw the keyboard with cursor
def draw_keyboard(selected_row, selected_col):
    key_width = 50
    key_height = 50
    x_offset = 50
    y_offset = 50
    y = y_offset
    for i, row in enumerate(keyboard_layout):
        x = x_offset
        for j, key in enumerate(row):
            color = GREEN if (i, j) == (selected_row, selected_col) else WHITE
            pygame.draw.rect(screen, color, (x, y, key_width, key_height))
            text_surface = font.render(key, True, BLACK)
            screen.blit(text_surface, (x + key_width // 4, y + key_height // 4))
            x += key_width + 10
        y += key_height + 10

# Main loop
running = True
selected_row = 0
selected_col = 0
text = ""
while running:
    screen.fill(BLACK)
    draw_keyboard(selected_row, selected_col)
    text_surface = font.render(text, True, WHITE)
    screen.blit(text_surface, (50, SCREEN_HEIGHT - 100))
    pygame.display.flip()

    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
        elif event.type == pygame.JOYHATMOTION:
            # Move the cursor based on joystick input (buttons 11 to 14)
            hat_x, hat_y = event.value
            if hat_x == -1:
                selected_col = (selected_col - 1) % len(keyboard_layout[selected_row])
            elif hat_x == 1:
                selected_col = (selected_col + 1) % len(keyboard_layout[selected_row])
            elif hat_y == -1:
                selected_row = (selected_row - 1) % len(keyboard_layout)
            elif hat_y == 1:
                selected_row = (selected_row + 1) % len(keyboard_layout)
        elif event.type == pygame.JOYBUTTONDOWN:
            # Handle button presses
            button = event.button
            if button == 11:  # Button 11 (UP)
                selected_row = (selected_row - 1) % len(keyboard_layout)
            elif button == 12:  # Button 12 (DOWN)
                selected_row = (selected_row + 1) % len(keyboard_layout)
            elif button == 13:  # Button 13 (LEFT)
                selected_col = (selected_col - 1) % len(keyboard_layout[selected_row])
            elif button == 14:  # Button 14 (RIGHT)
                selected_col = (selected_col + 1) % len(keyboard_layout[selected_row])
            elif joystick.get_button(button):  # For other buttons
                if keyboard_layout[selected_row][selected_col] == 'SPACE':
                    text += ' '
                elif keyboard_layout[selected_row][selected_col] == 'BACK':
                    text = text[:-1]
                elif keyboard_layout[selected_row][selected_col] == 'ENTER':
                    text = ""
                else:
                    text += keyboard_layout[selected_row][selected_col]

pygame.quit()
