ARG APACHE_VERSION=""
FROM httpd:${APACHE_VERSION:+${APACHE_VERSION}-}alpine

RUN apk update; \
  apk upgrade;

  # RUN apt-get update && apt-get install -y libmcrypt-dev \
  #     && pecl install mcrypt-1.0.2 \
  #     && docker-php-ext-enable mcrypt

RUN  docker-php-ext-install mysqli pdo pdo_mysql

# Copy apache vhost file to proxy php requests to php-fpm container
COPY demo.apache.conf /usr/local/apache2/conf/demo.apache.conf
RUN echo "Include /usr/local/apache2/conf/demo.apache.conf" \
  >> /usr/local/apache2/conf/httpd.conf

RUN sed -i '/LoadModule rewrite_module/s/^#//g' /usr/local/apache2/conf/httpd.conf

RUN { \
  echo 'IncludeOptional conf.d/*.conf'; \
  } >> /usr/local/apache2/conf/httpd.conf \
  && mkdir /usr/local/apache2/conf.d

EXPOSE 80
EXPOSE 443
