#!/bin/bash
pathGPIO="/sys/class/gpio/gpio$1/direction"
echo $1 >> "/home/pi/Desktop/mira.txt"
echo $2 >> "/home/pi/Desktop/mira.txt"
echo $pathGPIO >> "/home/pi/Desktop/mira.txt"
sudo sh -c "echo $1 > /sys/class/gpio/export"
sudo sh -c "echo out > $pathGPIO"
if [ "$2" = "1" ]
then
sudo sh -c "echo 0 > /sys/class/gpio/gpio$1/value"
else
sudo sh -c "echo 1 > /sys/class/gpio/gpio$1/value"
fi
exit 0