#!/usr/bin/env python
import pygame
import sys

pygame.init()

# Set up the screen
screen = pygame.display.set_mode((1280, 670), pygame.SRCALPHA)
pygame.display.set_caption("Joystick D-pad Menu")

pygame.joystick.init()
if pygame.joystick.get_count() == 0:
    print("No joystick detected.")
    sys.exit()

joystick_count = pygame.joystick.get_count()

if joystick_count == 0:
    print("No joysticks found.")
else:
   # print(f"Number of joysticks detected: {joystick_count}")

    # Create a list of connected joysticks
    joysticks = [pygame.joystick.Joystick(i) for i in range(joystick_count)]
    for joystick in joysticks:
        joystick.init()

font = pygame.font.SysFont(None, 36)

WIDTH, HEIGHT = 0, 0
WHITE = (255, 255, 255)
GREEN = (0, 255, 0)
BUTTON_WIDTH = 600
BUTTON_HEIGHT = 50
BUTTON_SPACING = 20

def draw_button(x, y, text, selected):
    rect = pygame.Rect(x, y, BUTTON_WIDTH, BUTTON_HEIGHT)
    pygame.draw.rect(screen, GREEN if selected else (255,0,0), rect, 2)
    text_surf = font.render(text, True, (0,0,0))
    text_rect = text_surf.get_rect(center=rect.center)
    screen.blit(text_surf, text_rect)
    return rect

def navigate_menu(selected_item, dy):
    new_y = max(0, min(selected_item + dy, len(joysticks) - 1))
    return new_y

def handle_action(selected_item):
    print("Selected:", joysticks[selected_item].get_name())


def main_menu():
    selected_item = 0

    running = True
    while running:
        screen.fill((100,100,100))
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                running = False
            elif event.type == pygame.MOUSEBUTTONDOWN:
                if event.button == 1:  # Left mouse button
                    mouse_pos = pygame.mouse.get_pos()
                    for i, joystick in enumerate(joysticks):
                        x = (screen.get_width() - BUTTON_WIDTH) // 2
                        y = BUTTON_SPACING + i * (BUTTON_HEIGHT + BUTTON_SPACING)
                        button_rect = draw_button(x, y, joystick.get_name(), selected_item == i)
                        if button_rect.collidepoint(mouse_pos):
                            selected_item = i
                            handle_action(selected_item)
                            print(selected_item)
                            running = False

    # Draw menu items
        for i, joystick in enumerate(joysticks):
            x = (screen.get_width() - BUTTON_WIDTH) // 2
            y = BUTTON_SPACING + i * (BUTTON_HEIGHT + BUTTON_SPACING)
            draw_button(x, y, joystick.get_name(), selected_item == i)

        pygame.display.flip()
        pygame.time.delay(50)

    pygame.quit()
