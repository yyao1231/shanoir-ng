FROM jboss/keycloak:2.5.1.Final
ARG profile=dev

ADD shanoir-theme /opt/jboss/keycloak/themes/shanoir-theme

COPY shanoir-theme/login/theme-$profile.properties /opt/jboss/keycloak/themes/shanoir-theme/login/theme.properties