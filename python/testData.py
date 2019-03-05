import tensorflow as tf
import numpy

# READEING TEST IMAGES

with open("D:\\Bilder\\Tensorflow\\Data\\testData.csv", "r") as file:
    lines = file.readlines()
    values = numpy.zeros((7, 4096), dtype=int)
    s = 0
    for i in range(len(lines)):
        for j in range(len(lines[i])):
            a = lines[i][j]
            if a.isdigit():
                values[i][s] = int(a)
                s += 1
        s = 0
    TESTIMAGES = tf.constant(values)
