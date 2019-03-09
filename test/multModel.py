import tensorflow as tf
from tensorflow.keras.callbacks import TensorBoard
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense, Flatten
import numpy as np
import time

xTrain = np.load("X.npy")
yTrain = np.load("y.npy")

xTrain = xTrain/255

logDir = "D:\\Bilder\\Tensorflow\\logsTestMult"

nDense = [2]
lSizes = [[32, 64, 128, 256, 512], [32, 64, 128, 256, 512]]
nOut = 36

for denseNumber in nDense:
    for nH1 in lSizes[0]:
        for nH2 in lSizes[1]:
            name = "(64,64),{},{},36NN_{}".format(nH1, nH2, time.time())
            tensorboard = TensorBoard(log_dir=logDir + "\\{}".format(name))

            model = Sequential([
                Flatten(name="flattening", input_shape=(64, 64)),
                Dense(nH1, name="first_hidden", activation=tf.nn.relu),
                Dense(nH2, name="second_hidden", activation=tf.nn.relu),
                Dense(nOut, name="output", activation=tf.nn.sigmoid)
            ])

            model.compile(optimizer="adam", loss="sparse_categorical_crossentropy",
                          metrics=["accuracy"])

            model.fit(xTrain, yTrain, epochs=10, batch_size=150,
                      validation_split=0.1, callbacks=[tensorboard])
