# Stage 1: Building artifact
FROM node:latest as node
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build --prod

# Stage 2: Running artifact
FROM nginx:alpine
COPY --from=node /app/dist/demo-app /usr/share/nginx/html