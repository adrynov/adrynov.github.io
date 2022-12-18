FROM postgres:14.4

# install PostGIS and osm2pgsql
RUN apt-get update && apt-get install -y postgresql-14-postgis-3 \
    wget make cmake g++ libboost-dev libboost-system-dev \
    libboost-filesystem-dev libexpat1-dev zlib1g-dev \
    libbz2-dev libpq-dev libproj-dev lua5.2 liblua5.2-dev \
    osm2pgsql

CMD ["/usr/local/bin/docker-entrypoint.sh","postgres"]