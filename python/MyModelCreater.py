from tensorflow.keras.callbacks import TensorBoard
from tensorflow.keras.layers import Dense, Flatten
from tensorflow.keras.models import Sequential
from tensorflow.nn import relu, sigmoid
import numpy as np
import time
import os

print("start creating model")

print("load training data")
# load data, these is the prepared dataset
xTrain = np.load("X.npy")
yTrain = np.load("y.npy")

# set name and directory for Tensorboard
name = "(64,64),128,512,36NN_relu..sigmoid,adam,SparseCatCross_{}".format(int(time.time()))
logDir = "D:\\Bilder\\Tensorflow\\logs"

# init Tensorboard callback
tensorboard = TensorBoard(log_dir=os.path.join(logDir, "{}".format(name)))

# init var for layersizes
ImageSize = 64
nH1 = 128
nH2 = 512
nOut = 36

print("creating model")

# create model as a Sequential model
model = Sequential([
    Flatten(name="flattening", input_shape=(ImageSize, ImageSize)),
    Dense(nH1, name="first_hidden", activation=relu),
    Dense(nH2, name="second_hidden", activation=relu),
    Dense(nOut, name="output", activation=sigmoid)
])

print("compile model")
# compile the model (that means set optimizer and loss function)
# metrics means what will be tracked additinally in the training process
model.compile(optimizer="adam", loss="sparse_categorical_crossentropy", metrics=["accuracy"])

print("fit model")
# train the model
model.fit(xTrain, yTrain, epochs=10, batch_size=150, validation_split=0.2, callbacks=[tensorboard])

# show how the model is structured
model.summary()
model.save("MyModel.h5")

print("model saved")
print("you can view the model in tensorboard under '{}' with the name '{}'".format(logDir, name))
