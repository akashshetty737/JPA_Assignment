package com.lti.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.lti.model.Author;
import com.lti.model.Book;

public class Main {
	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
	static EntityManager entityManager = factory.createEntityManager();
	public static void loadData(){
		
		
		Author author1 = new Author();
		author1.setAuthorId(100);
		author1.setAuthorName("Chetan Bhagat");
		
		Author author2 = new Author();
		author2.setAuthorId(101);
		author2.setAuthorName("Ketan Bhagat");
		
		Author author3 = new Author();
		author3.setAuthorId(102);
		author3.setAuthorName("Besan Bhagat");
		
		List<Author> list2 = new ArrayList<Author>();
		list2.add(author1);
		list2.add(author2);
		list2.add(author3);
		
		List<Author> list3 = new ArrayList<Author>();
		list3.add(author1);
		list3.add(author3);
		
		Book comic = new Book();
		comic.setISBN(10);
		comic.setBookTitle("Mowgli");
		comic.setBookPrice(250);
		comic.setAuthors(list2);
		
		Book drama = new Book();
		drama.setISBN(20);
		drama.setBookTitle("FRIENDS");
		drama.setBookPrice(500);
		drama.setAuthors(list2);
		
		Book action = new Book();
		action.setISBN(30);
		action.setBookTitle("Deadpool");
		action.setBookPrice(1000);
		action.setAuthors(list3);
		
		List<Book> list1 = new ArrayList<Book>();
		list1.add(comic);
		list1.add(drama);
	
		
		List<Book> list4 = new ArrayList<Book>();
		list1.add(action);	
		
		author1.setBooks(list1);
		author2.setBooks(list1);
		author3.setBooks(list4);
		
		
		entityManager.getTransaction().begin();	
		entityManager.persist(action);
		entityManager.persist(drama);
		entityManager.persist(comic);		
		entityManager.getTransaction().commit();

		
	}
	
	public static void one(){
		String jpql = "Select b From Book b";
		TypedQuery<Book> tquery = entityManager.createQuery(jpql, Book.class);
		List<Book> result = tquery.getResultList();
		
		for(Book b1 : result){
			System.out.println("Book ISBN: " +b1.getISBN());
			System.out.println("Book Name: " +b1.getBookTitle());
			System.out.println("Book Price: " +b1.getBookPrice());
			
		List<Author> authors = b1.getAuthors();
			for(Author a: authors){
				System.out.println("Author Id: " +a.getAuthorId());
				System.out.println("Author Name: " +a.getAuthorName());
			}
			
		System.out.println( "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		}
	}
	
	public static void two(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Author Name: ");
		String name = sc .nextLine();
		String jpql = "SELECT b FROM Book b JOIN b.authors a WHERE a.authorName ='" +name+"'";
		TypedQuery tquery = entityManager.createQuery(jpql, Book.class);
//		tquery.setParameter("name", name);
		List<Book> b = tquery.getResultList();
		System.out.println(b);
				for(Book b1 : b){
			System.out.println("Book ISBN: " +b1.getISBN());
			System.out.println("Book Name: " +b1.getBookTitle());
			System.out.println("Book Price: " +b1.getBookPrice());
			
		List<Author> authors = b1.getAuthors();
			for(Author a: authors){
				System.out.println("Author Id: " +a.getAuthorId());
				System.out.println("Author Name: " +a.getAuthorName());
			}
			
		System.out.println( "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		}
		sc.close();
	}
	public static void three(){
	
		String jpql = "SELECT b FROM Book b  WHERE b.bookPrice BETWEEN 500 AND 1000";
		TypedQuery tquery = entityManager.createQuery(jpql, Book.class);
//		tquery.setParameter("name", name);
		List<Book> b = tquery.getResultList();
		System.out.println(b);
				for(Book b1 : b){
			System.out.println("Book ISBN: " +b1.getISBN());
			System.out.println("Book Name: " +b1.getBookTitle());
			System.out.println("Book Price: " +b1.getBookPrice());
			
		List<Author> authors = b1.getAuthors();
			for(Author a: authors){
				System.out.println("Author Id: " +a.getAuthorId());
				System.out.println("Author Name: " +a.getAuthorName());
			}
			
		System.out.println( "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		}

	}
	public static void four(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Book id: ");
		int isbn = sc .nextInt();
		String jpql = "SELECT a FROM Author a JOIN a.books b WHERE b.ISBN =" +isbn;
		TypedQuery tquery = entityManager.createQuery(jpql, Author.class);
//		tquery.setParameter("name", name);
		List<Author> a = tquery.getResultList();
		System.out.println(a);
				for(Author a1 : a){
		
			System.out.println("Author Id: " +a1.getAuthorId());
			System.out.println("Author Name: " +a1.getAuthorName());
			
		List<Book> books = a1.getBooks();
			for(Book b: books){
				System.out.println("Book ISBN: " +b.getISBN());
				System.out.println("Book Name: " +b.getBookTitle());
				System.out.println("Book Price: " +b.getBookPrice());
				
			}
			
		System.out.println( "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		}
		sc.close();
	}
	public static void main(String[] args) {
		loadData();
		
		four();
		
	}

}
