/*
* OrderedListUtility Class
* Alex Nunes
* 13/10/2014
* Dalhousie University
* Faculty of Computer Science
*
* OrderedListUtility class that contains three methods:
* 1. Merge 2 ordered lists together
* 2. Finds the matching elements and creates a new list
* 3. Finds the non-mathcing elements ans creates a new list
*/
import java.util.Scanner;
import java.io.*;
public class OrderedListUtility{
	//Method 1
	public static <T extends Comparable<T>> OrderedList<T> merge(OrderedList<T> first, OrderedList<T> second){
		OrderedList<T> newList = new OrderedList<T>();
		T list1Item = first.first(), list2Item = second.first();
		while(list1Item != null && list2Item != null){
			if(list1Item.compareTo(list2Item) < 0){
				newList.insert(list1Item);
				list1Item = first.next();
			} else if(list1Item.compareTo(list2Item) > 0){
				newList.insert(list2Item);
				list2Item = second.next();
			}else{
				newList.insert(list1Item);
				list1Item = first.next();
				list2Item = second.next();
			}
		}
		
		if(list1Item == null){
			while(list2Item != null){
				newList.insert(list2Item);
				list2Item = second.next();
			}
		}
		if(list2Item == null){
			while(list1Item != null){
				newList.insert(list1Item);
				list2Item = first.next();
			}
		}
		return newList;
	}
	
	//Method 2
	public static <T extends Comparable<T>> OrderedList<T> findIntersection (OrderedList<T> first, OrderedList<T> second){
		OrderedList<T> newList = new OrderedList<T>();
		T list1Item = first.first(), list2Item = second.first();
		while(list1Item != null && list2Item != null){
			if(first.binarySearch(list2Item) >= 0){
				newList.insert(list2Item);
			}else if(second.binarySearch(list1Item) >=0 ){
				newList.insert(list1Item);
			}
			list1Item = first.next();
			list2Item = second.next();
		}
		return newList;
	}
	
	//Method 3
	public static <T extends Comparable<T>> OrderedList<T> findDifference(OrderedList<T> first, OrderedList<T> second){
		OrderedList<T> newList = new OrderedList<T>();
		T list1Item = first.first(), list2Item = second.first();
		
		while(list2Item != null){
			if(first.binarySearch(list2Item) < 0){
				newList.insert(list2Item);
			}
			list2Item = second.next();
		}
		
		while(list1Item != null){
			if(second.binarySearch(list1Item) < 0){
				newList.insert(list1Item);
			}
			list1Item = first.next();
		}
		return newList;
	}
}