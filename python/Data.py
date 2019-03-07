import numpy as np

print("laoding training data...")

# UTIL FUNCTION


def file_len(fname):
    with open(fname) as f:
        for i, l in enumerate(f):
            pass
    return i + 1

# READEING TRAIN DATA


loaded_data = True
dataPath = "D:\\Bilder\\Tensorflow\\Data\\training_data.npy"

path = "D:\\Bilder\\Tensorflow\\Data\\MyTrainSet"
filenames = [path + "0-3.csv", path + "4-9.csv", path + "A-E.csv", path +
             "F-J.csv", path + "K-O.csv", path + "P-T.csv", path + "U-Z.csv"]

if not loaded_data:
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
    np.save(dataPath, training_data)
else:
    print("load saved Array")
    training_data = np.load(dataPath)

# print(len(training_data))
#
# print("unshuffled:")
# for sample in training_data[:10]:
#     print(sample[1])
print("shuffle")
np.random.shuffle(training_data)

# print("shuffled:")
# for sample in training_data[:10]:
#     print(sample[1])
print("unpacking data")
xTrain = []
ys = []
for x, y in training_data:
    xTrain.append(x)
    ys.append(y)
print("casting xTrain")
xTrain = np.array(xTrain).reshape(-1, 4096)
n_labels = 36
targets = np.array(ys)
yTrain = np.zeros((targets.shape[0], n_labels))
yTrain[np.arange(targets.shape[0]), targets] = 1

print("done loading data")
