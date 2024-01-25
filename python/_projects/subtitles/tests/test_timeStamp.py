from unittest import TestCase


class Testclass_timeStamp(TestCase):

    def test_timeStamp_init():

        timeStamp_current = timeStamp(code, size=200, price=10,
                                  longitude=-0.09998975,
                                  latitude=51.75436293)
        assert storageroom.code == code
        assert storageroom.size == 200
        assert storageroom.price == 10
        assert storageroom.longitude == -0.09998975
        assert storageroom.latitude == 51.75436293