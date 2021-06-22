# Building Docker images

Docker images for `spring-boot` based service applications are built with the
[build-image](https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/htmlsingle/#build-image)
maven goal of `spring-boot-maven-plugin`.

This goal is tied to the `docker` maven profile, which is active by default.

`build-image` creates an [OCI](https://github.com/opencontainers/image-spec/blob/master/spec.md) (Open Container Initiative)
 compatible docker image using [Cloud Native Buildpacks](https://buildpacks.io/)
