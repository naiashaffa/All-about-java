package Struktur_data.MODUL;
//doubleLinked
import java.util.Scanner;
import static java.lang.System.out;

////////////////////////////////////////////////////////////////

class Node {
	public String Data1;
	public Node next;
	public Node previous;

// -------------------------------------------------------------

	public Node(String dat1) {
		Data1 = dat1;
	}

// -------------------------------------------------------------

	public String tampilNode() {
		return Data1;
	}

// -------------------------------------------------------------
} // end class Node

////////////////////////////////////////////////////////////////

class doubleLink {
	private Node first; 
	private Node last;
	private Node temp;
	private int count=0;

// -------------------------------------------------------------

	public doubleLink() { 
		first = null; 
		last = null; 
	}

// -------------------------------------------------------------

	public boolean isEmpty() { 
		return first==null;
	}

// -------------------------------------------------------------

	public void insertFirst(String dat1) { 
		Node newNode = new Node(dat1);
		if(isEmpty())
			last = newNode;
		else
			first.previous = newNode;
		newNode.next = first;
		first = newNode;
		count++;
	}

// -------------------------------------------------------------

	public void insertLast(String dat1) { 
		Node newNode = new Node(dat1);
		if( isEmpty() )
			first = newNode;
		else {
			last.next = newNode;
			newNode.previous = last;
		}
		last = newNode;
		count++;
	}

// -------------------------------------------------------------

	public Node hapusFirst() { 
		temp = first; 
		if(first.next == null)
			last = null;
		else
			first.next.previous = null;
		first = first.next;
		count--;
		return temp;
	}

// -------------------------------------------------------------
	// menghapus data di akhir list
	public Node hapusLast() {
		temp = last;
		if(first.next == null)
			first = null;
		else
			last.previous.next = null;
		last = last.previous;
		count--;
		return temp;
	}

// -------------------------------------------------------------
	
	// memasukkan data setelah data tertentu
	public boolean insertAfter(String dat1, String dat2) {
		Node indek = first;
		while(indek.Data1.compareTo(dat2) != 0) {
			indek = indek.next;
			if(indek == null)
				return false; // data tidak ditemukan
		}
		Node newNode = new Node(dat1);
		if(indek == last) {
			newNode.next = null;
			last = newNode;
		}
		else {
			newNode.next = indek.next;
			indek.next.previous = newNode;
		}
		newNode.previous = indek;
		indek.next = newNode;
		count++;
		return true; // data ditemukan dan data baru dimasukkan
	}
	
// -------------------------------------------------------------
	
	// memasukkan data sebelum data tertentu
	public boolean insertBefore(String dat1, String dat2) {
		Node indek = first;
		while(indek.Data1.compareTo(dat2) != 0) {
			indek = indek.next;
			if(indek == null)
				return false; // data tidak ditemukan
		}
		Node newNode = new Node(dat1);
		if(indek == first) {
			newNode.next = indek;
			first=newNode;
		}
		else {
			newNode.next = indek;
			newNode.previous = indek.previous;
			indek.previous.next=newNode;
		}
		indek.previous=newNode;
		count++;
		return true; // data ditemukan dan data baru dimasukkan
	}
	
// -------------------------------------------------------------
	
	// menghapus data tertentu (tidak diawal maupun diakhir list)
	public Node hapus(String dat) {
		Node indek = first;
		while(indek.Data1.compareTo(dat) != 0) {
			indek = indek.next;
			if(indek == null)
				return null; // data tidak ditemukan
		}
		if(indek == first)
			first = indek.next;
		else
			indek.previous.next = indek.next;
		
		if(indek == last)
			last = indek.previous;
		else
			indek.next.previous = indek.previous;
			
		count--;
		return indek;
	}

// -------------------------------------------------------------

	public void displayList(boolean hps) {
		Node indek = first;

		for(int a=0;a<=count;a++)
			if(a==1 && a==count)
				out.print("     First / Last");
			else if(a==1)
				out.print("     First");
			else if(a!=1 && a==count && a!=0)
				out.print("      Last ");
			else if(a==0 && count==0)
				out.print("Hapus");
			else if(a==0 && hps==false)
				out.print("      ");
			else if(a==0 && hps==true)
				out.print("Hapus ");
			else
				out.print("          ");
		out.println();
		
		for(int b=0;b<=count;b++)		
			if(b==1)
				out.print("    |");
			else if(b==count)
				out.print("          |");
			else if(b>=2 && hps==false)
				out.print("           ");
			else if(b==0 && hps==true)
				out.print("       |");
			else
				out.print("         ");
		out.println();
		
		for(int c=0;c<=count;c++)
			if(c==1)
				out.print("    V");
			else if(c==count)
				out.print("          V");
			else if(c>=2 && hps==false)
				out.print("           ");
			else if(c==0 && hps==true)
				out.print("       V");
			else
				out.print("         ");
		out.println();
		
		for(int i=0;i<=count;i++)
			if(i==0 && hps==false)
				out.print("      ");
			else if(i==0 && hps==true)
				out.print("----- ");
			else {
				if(i==1)
					out.print("     ");
				if(i==count)
					out.print("#####----> NULL");
				else
					out.print("#####----> ");
			}
		out.println();
			
		for(int j=0;j<=count;j++) {
			if(j==0 && hps==false)
				out.print("      ");
			else if(j==0 && hps==true)
				out.print("| " + temp.tampilNode() + " | ");
			else {
				if(count==1)
					out.print("     # " + indek.tampilNode() + " #");
				else
					out.print("     # " + indek.tampilNode() + " # ");
				/*if(j==count)
					out.print(" --> NULL");
				else
					out.print(" --> ");*/
				indek = indek.next;
			}
		}
		out.println();
		
		for(int k=0;k<=count;k++)
			if(k==0 && hps==false)
				out.print(" NULL ");
			else if(k==0 && hps==true)
				out.print("----- ");
			else {
				if(k==1)
					out.print("<----#####");
				else
					out.print(" <----#####");
			}

		out.println();
		out.println();
	}

// -------------------------------------------------------------
} // end class firstEndList
////////////////////////////////////////////////////////////////

class DoubleLinkAnim {
	public static void main(String[] args) {
		doubleLink theList = new doubleLink();
		int menu,menu1;
		String data;
		do {
			out.println("Pilih Menu");
			out.println("1. Tambah data");
			out.println("2. Ambil data");
			out.println("3. Lihat data");
			out.println("4. Keluar");
			out.print("Pilihan anda --> : ");
  			Scanner input = new Scanner(System.in);
  	    	menu = input.nextInt();
  	    	out.println();
  	    	
//--------------------------------------------------------------
			
			switch(menu) {
				case 1 : {
					do {
						out.println("Pilih Menu");
						out.println("1. Tambah data diawal");
						out.println("2. Tambah data diakhir");
						out.println("3. Keluar");
						out.print("Pilihan anda --> : ");
  	    				menu1 = input.nextInt();
			  	    	out.println();
						switch(menu1) {
							case 1 : {
								out.println("               PERHATIAN !!!!");
								out.println("DATA BERUPA ANGKA SATU DIGIT TIDAK BOLEH NOL");
								out.print("Datanya --> ");
								data = input.next();
								if(data.compareTo("1")!=0 && data.compareTo("2")!=0 &&
								   data.compareTo("3")!=0 && data.compareTo("4")!=0 &&
								   data.compareTo("5")!=0 && data.compareTo("6")!=0 &&
								   data.compareTo("7")!=0 && data.compareTo("8")!=0 &&
								   data.compareTo("9")!=0) {
									out.println("INPUT DATA SALAH !!!");
									out.println();
								}
								else {
									theList.insertFirst(data);
									out.println();
									theList.displayList(false);
								}
								break;
							}
							
							case 2 : {
								out.println("               PERHATIAN !!!!");
								out.println("DATA BERUPA ANGKA SATU DIGIT TIDAK BOLEH NOL");
								out.print("Datanya --> ");
								data = input.next();
								if(data.compareTo("1")!=0 && data.compareTo("2")!=0 &&
								   data.compareTo("3")!=0 && data.compareTo("4")!=0 &&
								   data.compareTo("5")!=0 && data.compareTo("6")!=0 &&
								   data.compareTo("7")!=0 && data.compareTo("8")!=0 &&
								   data.compareTo("9")!=0) {
									out.println("INPUT DATA SALAH !!!");
									out.println();
								}
								else {
									theList.insertLast(data);
									out.println();
									theList.displayList(false);
								}
								break;
							}
						}
					} while(menu1>0 && menu1<3);
					break;
				}
				
				case 2 : {
					if(!theList.isEmpty()) {
						theList.hapusFirst();
						out.println();
						theList.displayList(true);
						out.println();
					}
					else {
						out.println("Maaf, tidak ada data");
						out.println();
					}
					break;
				}
				
				case 3 : {
					if(!theList.isEmpty()) {
						theList.displayList(false);
						out.println();
					}
					else {
						out.println("Maaf, tidak ada data");
						out.println();
					}
					break;
				}
			}
		} while(menu > 0 && menu < 4);
	} // end main()
} // end class DoubleEndLinkedAnim

////////////////////////////////////////////////////////////////