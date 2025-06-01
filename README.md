# Blog Application

A modern blogging platform built with Spring Boot and React.

## Project Structure

The project is organized into two main directories:

### Backend (Spring Boot)

- Built with Java Spring Boot
- RESTful API architecture
- Uses Maven for dependency management
- Docker support included

### Frontend (React)

- Built with React + TypeScript
- Uses Vite as build tool
- Styled with Tailwind CSS
- Modern component-based architecture

## Prerequisites

- Java 17 or higher
- Node.js 18 or higher
- Docker (optional, for containerization)
- pnpm (for frontend package management)

## Getting Started

### Backend Setup

1. Navigate to the Backend directory:

```bash
cd Backend
```

2. Run the Spring Boot application:

```bash
./mvnw spring-boot:run
```

The backend server will start at `http://localhost:8080`

### Frontend Setup

1. Navigate to the Frontend directory:

```bash
cd Frontend
```

2. Install dependencies:

```bash
pnpm install
```

3. Start the development server:

```bash
pnpm dev
```

The frontend application will be available at `http://localhost:5173`

## Features

- User authentication
- Create, read, update, and delete blog posts
- Category management
- Tag system
- Draft post support

## Development

- Backend API documentation is available at `http://localhost:8080/swagger-ui.html`
- The frontend uses TypeScript for type safety
- Built with modern best practices and coding standards

## License

This project is licensed under the MIT License - see the LICENSE file in the Frontend directory for details.
