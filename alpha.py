import numpy as np
import scipy
import scipy.spatial
from random import random

def three_d_alpha_shape(points, alpha = 0.1):
    return points

def unit_test():

    points = [(random(), random(), random()) for i in range(500)]

    print(scipy.spatial.delaunay(points))

    print(three_d_alpha_shape(points))

unit_test()