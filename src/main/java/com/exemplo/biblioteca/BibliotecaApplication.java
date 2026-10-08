package com.exemplo.biblioteca;

import com.exemplo.biblioteca.controller.MenuPrincipal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class BibliotecaApplication {

	public static void main(String[] args) {

		var context = SpringApplication.run(BibliotecaApplication.class, args);

		MenuPrincipal menuPrincipal = context.getBean(MenuPrincipal.class);

		Scanner scanner = new Scanner(System.in);

		menuPrincipal.iniciar(scanner);

		scanner.close();
	}
}