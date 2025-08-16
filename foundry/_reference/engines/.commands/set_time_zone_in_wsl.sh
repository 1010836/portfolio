#distro Alpine

apk update

# install timezone data
apk add --no-cache tzdata

# set Dublin time
cp /usr/share/zoneinfo/Europe/Dublin /etc/localtime
echo "Europe/Dublin" > /etc/timezone

# (optional) remove tzdata to slim down image
apk del tzdata