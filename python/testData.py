import tensorflow as tf
import numpy

# READEING TEST IMAGES


testImg = open("D:\\Bilder\\Tensorflow\\Data\\testData.csv", "r")
testImgString = testImg.readlines()
value2 = numpy.zeros((7, 4096), dtype=int)
s = 0
for i in range(7):
    for j in range(4096):
        a = testImgString[i][s]
        if a.isdigit():
            tmp = int(a)
            value2[i][j] = tmp
        s += 3
        if s == len(testImgString[i]):
            s -= 1
        elif s > len(testImgString[i]):
            break
    s = 0
TESTIMAGES = tf.constant(value2)
testImg.close()
