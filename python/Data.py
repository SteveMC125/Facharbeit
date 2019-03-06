import tensorflow as tf
import numpy
import random

print("laoding training data...")

# UTIL FUNCTION


def file_len(fname):
    with open(fname) as f:
        for i, l in enumerate(f):
            pass
    return i + 1

# READEING TRAIN DATA


path = "D:\\Bilder\\Tensorflow\\Data\\MyTrainSet"
filenames = [path + "0-3.csv", path + "4-9.csv", path + "A-E.csv", path +
             "F-J.csv", path + "K-O.csv", path + "P-T.csv", path + "U-Z.csv"]

nFiles = len(filenames)

training_data = []
print("start getting data")
for file in filenames:
    with open(file) as opened:
        lines = opened.readlines()
        for i in range(len(lines)):
            columns = lines[i].split(",")
            tmplabel = int(columns[-1])
            tmpfeature = []
            for test in columns[:-1]:
                tmpfeature.append(int(test))
        training_data.append([tmpfeature, tmplabel])
print("got data")

# yTrain = tf.one_hot(labelList, 36)
# print("convert x to numpy array")
# xTrain = numpy.array(xs_all).reshape(-1, 4096)
for sample in training_data[:10]:
    print(sample[1])
random.shuffle(training_data)
for sample in training_data[:10]:
    print(sample[1])


print("done loading data")
