import tensorflow as tf
import numpy

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

xs = []
labelList = []

print("start laoding")

for file in filenames:
    opened = open(file)
    for i in range(file_len(file)):
        line = opened.readline()
        line = line[:-1]
        columns = line.split(",")
        features = columns[:-1]
        label = columns[-1]
        xs.append(features)
        labelList.append(int(label))
    opened.close()
print("done loading")

for i in range(len(xs)):
    for j in range(len(xs[i])):
        xs[i][j] = int(xs[i][j])

YS = tf.one_hot(labelList, 36)
XS = tf.concat(xs, 0)

# with tf.python_io.TFRecordWriter("test.tfrecord") as writer:
#     writer.write(YS.SerializeToString())

print("done loading data")

print(YS)
print(XS)
