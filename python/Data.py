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

XS = []
labelList = []

for file in filenames:
    with open(file) as opened:
        lines = opened.readlines()
        for i in range(len(lines)):
            columns = lines[i].split(",")
            labelList.append(int(columns[-1]))
            XS.append(columns[:-1])

for i in range(len(XS)):
    for j in range(len(XS[i])):
        XS[i][j] = int(XS[i][j])
YS = tf.one_hot(labelList, 36)

DATASET = tf.data.Dataset.from_tensor_slices((XS, YS))
DATASET = DATASET.shuffle(100)
DATASET = DATASET.batch(50)
DATASET = DATASET.repeat()

print("done loading data")
