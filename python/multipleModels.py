import tensorflow as tf
from tensorflow.keras.callbacks import TensorBoard
import numpy as np
import time

xTrain = np.load("xTrain.npy")
yTrain = np.load("yTrain.npy")

nIn = 4096
nDense = [1, 2]
lSizes = [[32, 64, 128, 256, 512], [32, 64, 128, 256, 512]]
nOut = 36

for denseNumber in nDense:
    if denseNumber == 1:
        for nH in lSizes[0]:
            name = "4096,{},36NN_{}".format(nH, time.time())
            tensorboard = TensorBoard(log_dir="D:\\Bilder\\Tensorflow\\logsMult2\\{}".format(name))
            model = tf.keras.models.Sequential()
            model.add(tf.keras.layers.Dense(nH, input_shape=(nIn,),
                                            name="first_hidden", activation=tf.nn.relu))
            model.add(tf.keras.layers.Dense(nOut, name="output", activation=tf.nn.softmax))

            model.compile(optimizer="adam", loss="categorical_crossentropy", metrics=["accuracy"])

            model.fit(xTrain, yTrain, epochs=5, batch_size=200,
                      validation_split=0.2, callbacks=[tensorboard])
    elif denseNumber == 2:
        for nH1 in lSizes[0]:
            for nH2 in lSizes[1]:
                name = "4096,{},{},36NN_{}".format(nH1, nH2, time.time())
                tensorboard = TensorBoard(
                    log_dir="D:\\Bilder\\Tensorflow\\logsMult2\\{}".format(name))
                model = tf.keras.models.Sequential()
                model.add(tf.keras.layers.Dense(nH1, input_shape=(nIn,),
                                                name="first_hidden", activation=tf.nn.relu))
                model.add(tf.keras.layers.Dense(nH2,
                                                name="second_hidden", activation=tf.nn.relu))
                model.add(tf.keras.layers.Dense(nOut, name="output", activation=tf.nn.softmax))

                model.compile(optimizer="adam", loss="categorical_crossentropy",
                              metrics=["accuracy"])

                model.fit(xTrain, yTrain, epochs=5, batch_size=200,
                          validation_split=0.2, callbacks=[tensorboard])
