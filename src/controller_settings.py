#!/usr/bin/env python

import pygame
import sys
from announcer_voice import *
from controller_layout import *

pygame.init()

# Set up the screen
screen_width = 1280
screen_height = 670
button_width = 600
button_height = 50
button_padding = 60
button_font = pygame.font.Font(None, 36)
GREEN = (0, 255, 0)
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)

screen = pygame.display.set_mode((screen_width, screen_height))
pygame.display.set_caption("Joystick Controller Buttons")

def get_connected_joysticks():
    pygame.joystick.init()
    joysticks = [pygame.joystick.Joystick(i) for i in range(pygame.joystick.get_count())]
    #print(joysticks)
    return joysticks

def navigate_menu(selected_item, dy, dx):
    joysticks_count = len(get_connected_joysticks())
    if joysticks_count == 0:
        return selected_item

    new_y = (selected_item + dy) % joysticks_count
    return new_y


# Function to draw buttons for each connected joystick controller
def draw_buttons(selected_item):
    screen.fill((10, 10, 10))
    joysticks = get_connected_joysticks()
    for i, joystick in enumerate(joysticks):
        button_text = joystick.get_name()
        x = (screen_width - button_width) // 2
        y = button_padding + i * (button_height + button_padding)
        button_rect = pygame.Rect(x, y, button_width, button_height)
        selected = (selected_item == i)
        pygame.draw.rect(screen, GREEN if selected else WHITE, button_rect, 2)
        text_surface = button_font.render(button_text, True, (255, 255, 255))
        text_rect = text_surface.get_rect(center=button_rect.center)
        screen.blit(text_surface, text_rect)

def controller_number():
    with open('config.txt', 'r') as file:
        lines = file.readlines()

    # Finding and modifying the desired line
    for i in range(len(lines)):
        if "Chosen Controller :" in lines[i]:
            parts = lines[i].rsplit(' ', 1)
            controller_number = parts[-1].strip()
    return int(controller_number)

def controller_settings():
    if pygame.joystick.get_count() == 1:
        return
    else:
        selected_item = 0
        font = pygame.font.Font(None, 36)
        running = True
        while running:
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    running = False
                elif event.type == pygame.KEYDOWN:
                    if event.key == pygame.K_ESCAPE:
                        going_back_sound()
                        running = False
                    elif event.key == pygame.K_w:
                        selected_item = navigate_menu(selected_item, -1, 0)
                        cursor_navigation_sound()
                    elif event.key == pygame.K_s:
                        selected_item = navigate_menu(selected_item, 1, 0)
                        cursor_navigation_sound()
                    elif event.key == pygame.K_RETURN:
                        selected_joystick = get_connected_joysticks()[selected_item]
                        controller_number = selected_item
                        going_back_sound()
                        with open('config.txt', 'r') as file:
                            lines = file.readlines()
                        for i in range(len(lines)):
                            if "Chosen Controller :" in lines[i]:
                                parts = lines[i].rsplit(' ', 1)
                                modified_line = parts[0] + ' ' + str(controller_number) + '\n'
                                lines[i] = modified_line

                        with open('config.txt', 'w') as file:
                            file.writelines(lines)
                        running = False
                draw_buttons(selected_item)
            if pygame.joystick.get_count() > 0:
                text = font.render("Press enter to choose your controller press 'w' and 's' to navigate", True, WHITE)
                text_rect = text.get_rect(center=(screen_width // 2, screen_height // 28))
                screen.blit(text, text_rect)
            elif pygame.joystick.get_count() == 0:
                text = font.render("Please connect a controller in order to use CodePlayer", True, WHITE)
                text_rect = text.get_rect(center=(screen_width // 2, screen_height // 2))
                screen.blit(text, text_rect)
            pygame.display.flip()
