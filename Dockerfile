FROM openjdk:8
COPY ./out/production/SeleniumLearningProject/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java","BaseTest"]