package com.floristeria.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Ticket {

	private int id;
	private static int next_id = 0;
	private LocalDateTime creationDate;
	private double totalValue;

	List<Producte> productList = new ArrayList<>();

	DateTimeFormatter format = DateTimeFormatter.ofPattern("'Data:' dd/MM/yyyy 'Hora:' HH:mm:ss");

	public Ticket(List<Producte> compra) throws Exception {
		if (compra.isEmpty())
			throw new Exception("Heu d'introduir com a m�nim un producte per crear un ticket.");
		id = next_id++;
		productList = compra;
		totalValue = compra.stream().mapToDouble((Producte::getPrice)).sum();
		creationDate = LocalDateTime.now();
	}

	public int getId() {
		return id;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public List<Producte> getProducts() {
		return productList;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	@Override
	public String toString() {
		return "Id_Ticket: " + id + "	" + creationDate.format(null) + "	Valor total: " + totalValue;
	}

	public void printTicket() {

		System.out.println(toString());
		productList.stream().forEach(System.out::println);
	}

}
