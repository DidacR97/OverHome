import RPi.GPIO as GPIO
import time
import socket
GPIO.setmode(GPIO.BCM)
GPIO.setup(24, GPIO.IN)
# GPIO.setup(18, GPIO.OUT)
UDP_IP = "35.204.23.49"
UDP_PORT = 12000
MESSAGE = "00010001;samuel"
while True:    
    while True:
        inputValue = GPIO.input(24)
        if (inputValue == True):
            GPIO.output(18, GPIO.HIGH)
            print("Main_Light Zone 4")
            sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM) # UDP
            sock.sendto(bytes(MESSAGE, "utf-8"), (UDP_IP, UDP_PORT))