import os
import subprocess
from text_editor_pygame import *

def create_batch_file(filename):
    with open('run_java.bat', 'w') as batch_file:
        #batch_file.write('javac *.java\n')
        batch_file.write(f'java Main {filename}\n')

def create_conversion_file():
    print(str(get_current_file()))
    #with open('converttxtsimple.bat', 'w') as batch_file:
        #batch_file.write('javac *.java\n')
     #   batch_file.write(f' {filename}\n')

def run_batch_file():
    directory = "Programs"
    if os.path.exists(directory):
        os.chdir(directory)  # Change the current working directory
        #x = input(f"Enter the name of the file you want to execute in '{directory}': ")
        x = "example"
        if os.path.exists(x):
            create_batch_file(x)
            print("Batch file created successfully.")
        else:
            print("File not found in the directory.")
    else:
        print(f"Directory '{directory}' not found.")

def open_batch_file(batch_file_path):
    try:
        subprocess.run(['start', 'cmd', '/k', batch_file_path], shell=True, check=True)
    except subprocess.CalledProcessError as e:
        print(f"Error occurred while executing the batch file: {e}")

def main():
    #batch_file_path = "run_java.bat"  # Specify the path to your batch file
    #run_batch_file()
    #open_batch_file(batch_file_path)
    create_conversion_file()

if __name__ == "__main__":
    main()