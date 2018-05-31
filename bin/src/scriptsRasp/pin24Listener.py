import RPi.GPIO as GPIO
import time
import socket
GPIO.setmode(GPIO.BCM)
GPIO.setup(24, GPIO.IN)
UDP_IP = "35.204.23.49"
UDP_PORT = 12000
MESSAGE = "00030001;guest,"
while True:    
    inputValue = GPIO.input(24)
    if (inputValue == True):
        print("action1")
        sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM) # UDP
        sock.sendto(bytes(MESSAGE, "utf-8"), (UDP_IP, UDP_PORT))
        time.sleep(1)
        inputValue = False