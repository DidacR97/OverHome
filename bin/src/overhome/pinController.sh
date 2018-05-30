#!/bin/bash
echo $1 > /sys/class/gpio/export

echo $2 > /sys/class/gpio/gpio17/direction

if [ $3 == '1']
then
	echo 1 > /sys/class/gpio/gpio17/value
else
	echo 0 > /sys/class/gpio/gpio17/value
fi