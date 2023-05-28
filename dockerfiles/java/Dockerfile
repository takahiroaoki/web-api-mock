FROM amazonlinux:2.0.20230504.1

# install basic tools
RUN yum -y update && yum install -y \
    systemd \
    shadow-utils \
    tar \
    unzip \
    sudo

# install java
RUN yum install -y java-17-amazon-corretto.x86_64
ENV JAVA_HOME=/usr

# install node.js
RUN curl -fsSL https://rpm.nodesource.com/setup_16.x | bash -
RUN yum install -y nodejs-16.20.0

# add user
ARG USER_NAME=dev-user
RUN useradd -m ${USER_NAME} && echo "${USER_NAME} ALL=NOPASSWD: ALL" >> /etc/sudoers
USER ${USER_NAME}