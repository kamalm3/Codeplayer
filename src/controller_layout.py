#!/usr/bin/env python

import pygame
from controller_settings import controller_number

def controller_initionalisation():
    pygame.joystick.init()
    # Check the number of connected joysticks
    joystick_count = pygame.joystick.get_count()

    if joystick_count == 0:
        print("No joysticks found.")
    else:
        joystick_number = controller_number()
        joystick = pygame.joystick.Joystick(joystick_number)
        joystick.init()

def controller_layout():
    joystick = pygame.joystick.Joystick(controller_number())

    if joystick.get_name() == "Controller (Xbox One For Windows)":
        background_image = pygame.image.load("images/xbox controller.png")
    if joystick.get_name() == "Xbox 360 Controller":
        background_image = pygame.image.load("images/xbox controller.png")
    if joystick.get_name() == "Xbox Series X Controller":
        background_image = pygame.image.load("images/xbox controller.png")
    if str(joystick.get_name()) == "DualSense Wireless Controller":
        background_image = pygame.image.load("images/ps controller.png")
    if str(joystick.get_name()) == "PS4 Controller":
        background_image = pygame.image.load("images/ps controller.png")
    if str(joystick.get_name()) == "Controller (ESM GAME FOR WINDOWS 1.05)":
        background_image = pygame.image.load("images/xbox controller.png")
    if str(joystick.get_name()) == "PLAYSTATION(R)3 Controller":
        background_image = pygame.image.load("images/ps controller.png")
    return background_image

def controller_layout_for_text_creation():
    joystick = pygame.joystick.Joystick(controller_number())

    if joystick.get_name() == "Controller (Xbox One For Windows)":
        controller_layout_image = pygame.image.load("images/xboxbuttons_for_creation_windows.png")
    if joystick.get_name() == "Xbox 360 Controller":
        controller_layout_image = pygame.image.load("images/xboxbuttons_for_creation_windows.png")
    if joystick.get_name() == "Xbox Series X Controller":
       controller_layout_image = pygame.image.load("images/xboxbuttons_for_creation_windows.png")
    if str(joystick.get_name()) == "DualSense Wireless Controller":
        controller_layout_image = pygame.image.load("images/playstationbuttons_for_creation_windows.png")
    if str(joystick.get_name()) == "PS4 Controller":
        controller_layout_image = pygame.image.load("images/playstationbuttons_for_creation_windows.png")
    if str(joystick.get_name()) == "Controller (ESM GAME FOR WINDOWS 1.05)":
       controller_layout_image = pygame.image.load("images/xboxbuttons_for_creation_windows.png")
    if str(joystick.get_name()) == "PLAYSTATION(R)3 Controller":
        controller_layout_image = pygame.image.load("images/playstationbuttons_for_creation_windows.png")
    return controller_layout_image

def controller_layout_for_variable_popup():
    joystick = pygame.joystick.Joystick(controller_number())

    if joystick.get_name() == "Controller (Xbox One For Windows)":
        controller_layout_image = pygame.image.load("images/xboxbuttons_variable_popup.png")
    if joystick.get_name() == "Xbox 360 Controller":
        controller_layout_image = pygame.image.load("images/xboxbuttons_variable_popup.png")
    if joystick.get_name() == "Xbox Series X Controller":
       controller_layout_image = pygame.image.load("images/xboxbuttons_variable_popup.png")
    if str(joystick.get_name()) == "DualSense Wireless Controller":
        controller_layout_image = pygame.image.load("images/playstationbuttons_variable_popup.png")
    if str(joystick.get_name()) == "PS4 Controller":
        controller_layout_image = pygame.image.load("images/playstationbuttons_variable_popup.png")
    if str(joystick.get_name()) == "Controller (ESM GAME FOR WINDOWS 1.05)":
       controller_layout_image = pygame.image.load("images/xboxbuttons_variable_popup.png")
    if str(joystick.get_name()) == "PLAYSTATION(R)3 Controller":
        controller_layout_image = pygame.image.load("images/playstationbuttons_variable_popup.png")
    return controller_layout_image

def controller_layout_for_other_windows():
    joystick = pygame.joystick.Joystick(controller_number())

    if joystick.get_name() == "Controller (Xbox One For Windows)":
        controller_layout_image = pygame.image.load("images/xboxbuttons_general.png")
    if joystick.get_name() == "Xbox 360 Controller":
        controller_layout_image = pygame.image.load("images/xboxbuttons_general.png")
    if joystick.get_name() == "Xbox Series X Controller":
       controller_layout_image = pygame.image.load("images/xboxbuttons_general.png")
    if str(joystick.get_name()) == "DualSense Wireless Controller":
        controller_layout_image = pygame.image.load("images/playstationbuttons_general.png")
    if str(joystick.get_name()) == "PS4 Controller":
        controller_layout_image = pygame.image.load("images/playstationbuttons_general.png")
    if str(joystick.get_name()) == "Controller (ESM GAME FOR WINDOWS 1.05)":
       controller_layout_image = pygame.image.load("images/xboxbuttons_general.png")
    if str(joystick.get_name()) == "PLAYSTATION(R)3 Controller":
        controller_layout_image = pygame.image.load("images/playstationbuttons_general.png")
    return controller_layout_image


def controller_buttons():
    joystick = pygame.joystick.Joystick(controller_number())
    if joystick.get_name() == "Controller (Xbox One For Windows)":
        controller_button_layout = {4: 'delete character', 5: 'space', 7: 'file menu', 8:'%', 9:',', 6: 'Help'}
    if joystick.get_name() == "Xbox 360 Controller":
        controller_button_layout = {4: 'delete character', 5: 'space', 7: 'file menu', 8:'%', 9:',', 6: 'Help'}
    if joystick.get_name() == "Xbox Series X Controller":
        controller_button_layout = {4: 'delete character', 5: 'space', 7: 'file menu', 8:'%', 9:',', 6: 'Help'}
    if str(joystick.get_name()) == "DualSense Wireless Controller":
        controller_button_layout = {9: 'delete character', 10: 'space', 6: 'file menu', 7:'%', 8:',', 4: 'Help'}
    if str(joystick.get_name()) == "PS4 Controller":
        controller_button_layout = {9: 'delete character', 10: 'space', 6: 'file menu', 7:'%', 8:',', 4: 'Help'}
    if str(joystick.get_name()) == "Controller (ESM GAME FOR WINDOWS 1.05)":
        controller_button_layout = {4: 'delete character', 5: 'space', 7: 'file menu', 8:'%', 9:',', 6: 'Help'}
    if str(joystick.get_name()) == "PLAYSTATION(R)3 Controller":
        controller_button_layout = {9: 'delete character', 10: 'space', 6: 'file menu', 7:'%', 8:',', 4: 'Help'}

    return controller_button_layout 

        