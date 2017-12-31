package com.gfb.hotelHero.ddengi.model;

import javax.xml.bind.annotation.*;
import java.util.*;

@XmlAccessorType(value = XmlAccessType.FIELD)
//@XmlType(name = "ns2:Map", propOrder = {
//        "type",
//        "items",
//})
//@XmlRootElement(name = "params")
//@XmlSeeAlso({Item.class})
public class GetRecordListRequestParams {

    @XmlAttribute(name = "xsd:type")
    protected String type = "ns2:Map";

    public String getType() {
        return type;
    }

    public GetRecordListRequestParams setType(String type) {
        this.type = type;
        return this;
    }

    @XmlElement(name = "item")
    protected List<Item> items = new ArrayList<>();


    public List<Item> getItems() {
        return items;
    }

    public GetRecordListRequestParams setItems(List<Item> items) {
        this.items = items;
        return this;
    }

    public GetRecordListRequestParams addItem(Item param) {
        this.items.add(param);
        return this;
    }

//    @Override
//    public int size() {
//        return items.size();
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return items.isEmpty();
//    }
//
//    @Override
//    public boolean contains(Object o) {
//        return items.contains(0);
//    }
//
//    @Override
//    public Iterator<Item> iterator() {
//        return items.iterator();
//    }
//
//    @Override
//    public Object[] toArray() {
//        return items.toArray();
//    }
//
//    @Override
//    public <T> T[] toArray(T[] ts) {
//        return items.toArray(ts);
//    }
//
//    @Override
//    public boolean add(Item item) {
//        return items.add(item);
//    }
//
//    @Override
//    public boolean remove(Object o) {
//        return items.remove(o);
//    }
//
//    @Override
//    public boolean containsAll(Collection<?> collection) {
//        return items.containsAll(collection);
//    }
//
//    @Override
//    public boolean addAll(Collection<? extends Item> collection) {
//        return items.addAll(collection);
//    }
//
//    @Override
//    public boolean addAll(int i, Collection<? extends Item> collection) {
//        return items.addAll(i, collection);
//    }
//
//    @Override
//    public boolean removeAll(Collection<?> collection) {
//        return items.removeAll(collection);
//    }
//
//    @Override
//    public boolean retainAll(Collection<?> collection) {
//        return items.retainAll(collection);
//    }
//
//    @Override
//    public void clear() {
//        items.clear();
//    }
//
//    @Override
//    public Item get(int i) {
//        return items.get(i);
//    }
//
//    @Override
//    public Item set(int i, Item item) {
//        return items.set(i, item);
//    }
//
//    @Override
//    public void add(int i, Item item) {
//        items.add(i, item);
//    }
//
//    @Override
//    public Item remove(int i) {
//        return items.remove(i);
//    }
//
//    @Override
//    public int indexOf(Object o) {
//        return items.indexOf(o);
//    }
//
//    @Override
//    public int lastIndexOf(Object o) {
//        return 0;
//    }
//
//    @Override
//    public ListIterator<Item> listIterator() {
//        return null;
//    }
//
//    @Override
//    public ListIterator<Item> listIterator(int i) {
//        return null;
//    }
//
//    @Override
//    public List<Item> subList(int i, int i1) {
//        return null;
//    }
}
