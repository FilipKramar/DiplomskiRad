FROM node:18.17.1 AS angular
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

FROM nginx:1.24.0-alpine AS product
COPY --from=angular /app/dist/petshealth /usr/share/nginx/html
EXPOSE 80
