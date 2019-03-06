import tensorflow as tf
from Data import xTrain, yTrain
import numpy as np

print("start creating model")

# 64 * 64 images
nIn = 4096
nH1 = 1024
nH2 = 512
nH3 = 512
nOut = 36
print("creating model")
model = tf.keras.models.Sequential([
    tf.keras.layers.Dense(nH1, input_shape=(nIn,), name="first_hidden", activation=tf.nn.sigmoid),
    tf.keras.layers.Dense(nH2, name="second_hidden", activation=tf.nn.sigmoid),
    tf.keras.layers.Dense(nH3, name="third_hidden", activation=tf.nn.sigmoid),
    tf.keras.layers.Dense(nOut, name="output", activation=tf.nn.sigmoid)
])
print("compile model")
model.compile(optimizer="adam", loss="mean_squared_error")
print("fit model")
model.fit(xTrain, yTrain, epochs=10, batch_size=32, validation_split=0.2)
model.summary()

model.save("MyModel.h5")

print("model saved")
