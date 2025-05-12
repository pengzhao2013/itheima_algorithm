package com.itheima.recursion_multi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author zpstart
 * @create 2023-08-22 19:07
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Book> booksList = new ArrayList<>();
        List<String> inputStr = new ArrayList<>();
        while (in.hasNext()) {
            inputStr.add(in.nextLine());
        }
        int booksNum = Integer.parseInt(inputStr.get(0));
        for (int i = 1; i <= booksNum; i++) {
            String[] split = inputStr.get(i).split(" ");
            booksList.add(new Book(split[0], Integer.parseInt(split[1])));
        }
        List<Book> newBookList = booksList.stream().sorted((book1, book2) -> {
            return book1.getBookPrice() - book2.getBookPrice();
        }).collect(Collectors.toList());
        for (int i = 0; i < booksNum; i++) {
            System.out.println(newBookList.get(i).getBookName());
        }
    }

    static class Book {
        private String bookName;

        private int bookPrice;

        public Book() {
        }

        public Book(String bookName, int bookPrice) {
            this.bookName = bookName;
            this.bookPrice = bookPrice;
        }

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public int getBookPrice() {
            return bookPrice;
        }

        public void setBookPrice(int bookPrice) {
            this.bookPrice = bookPrice;
        }
    }
}
