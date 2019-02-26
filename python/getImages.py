
def getDataset():
    path = "D:/Bilder/Tensorflow/Data/English/Fnt/Sample"
    image_paths = []
    for i in range(1, 37):
        for j in range(1, 1017):
            image_paths.append(path + "{:03d}/img{:03d}-{:05d}.png".format(i, i, j))
    cls_true = []
    for i in range(len(image_paths)):
        if(image_paths[i][51:54] == "001"):
            cls_true.append(0)
        if(image_paths[i][51:54] == "002"):
            cls_true.append(1)
        if(image_paths[i][51:54] == "003"):
            cls_true.append(2)
        if(image_paths[i][51:54] == "004"):
            cls_true.append(3)
        if(image_paths[i][51:54] == "005"):
            cls_true.append(4)
        if(image_paths[i][51:54] == "006"):
            cls_true.append(5)
        if(image_paths[i][51:54] == "007"):
            cls_true.append(6)
        if(image_paths[i][51:54] == "008"):
            cls_true.append(7)
        if(image_paths[i][51:54] == "009"):
            cls_true.append(8)
        if(image_paths[i][51:54] == "010"):
            cls_true.append(9)
        if(image_paths[i][51:54] == "011"):
            cls_true.append(10)
        if(image_paths[i][51:54] == "012"):
            cls_true.append(11)
        if(image_paths[i][51:54] == "013"):
            cls_true.append(12)
        if(image_paths[i][51:54] == "014"):
            cls_true.append(13)
        if(image_paths[i][51:54] == "015"):
            cls_true.append(14)
        if(image_paths[i][51:54] == "016"):
            cls_true.append(15)
        if(image_paths[i][51:54] == "017"):
            cls_true.append(16)
        if(image_paths[i][51:54] == "018"):
            cls_true.append(17)
        if(image_paths[i][51:54] == "019"):
            cls_true.append(18)
        if(image_paths[i][51:54] == "020"):
            cls_true.append(19)
        if(image_paths[i][51:54] == "021"):
            cls_true.append(20)
        if(image_paths[i][51:54] == "022"):
            cls_true.append(21)
        if(image_paths[i][51:54] == "023"):
            cls_true.append(22)
        if(image_paths[i][51:54] == "024"):
            cls_true.append(23)
        if(image_paths[i][51:54] == "025"):
            cls_true.append(24)
        if(image_paths[i][51:54] == "026"):
            cls_true.append(25)
        if(image_paths[i][51:54] == "027"):
            cls_true.append(26)
        if(image_paths[i][51:54] == "028"):
            cls_true.append(27)
        if(image_paths[i][51:54] == "029"):
            cls_true.append(28)
        if(image_paths[i][51:54] == "030"):
            cls_true.append(29)
        if(image_paths[i][51:54] == "031"):
            cls_true.append(30)
        if(image_paths[i][51:54] == "032"):
            cls_true.append(31)
        if(image_paths[i][51:54] == "033"):
            cls_true.append(32)
        if(image_paths[i][51:54] == "034"):
            cls_true.append(33)
        if(image_paths[i][51:54] == "035"):
            cls_true.append(34)
        if(image_paths[i][51:54] == "036"):
            cls_true.append(35)

    return image_paths, cls_true
