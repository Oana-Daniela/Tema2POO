Puisor Oana-Daniela
321 CD
	
	Tema2-MiniCAD

		Pentru implementarea temei 2, am folosit pentru partea de citire din
fisier acelasi model ca la tema 1: am creat clasa ReadInput unde am citit numarul
de forme si formele sub forma de string.

	Pentru implementarea formelor si a CANVAS-ului am folosit cele 3 design 
pattern-uri date in cerinta temei.Realizand intefata Visitor si clasa ce 
implementeaza(Desenator),practic am realizat toata modelarea unei planse 
cu forme.Clasele cu numele formelor si al CANVAS-ului,prin metoda accept
vor prelua datele prelucrate in urma citirii inputului fiecarui test.

	Singleton am folosit doar pentru a intanitia in cadrul clasei respective
obiectul corespunzator,o singura data.

	Formele citite de la input sub forma de stringuri le-am convertit la int 
pentru a realiza operatiile specifice cu ele.La formele mai simplu de 
realizat, respectiv CANVAS, patrat si dreptunghi am lucrat pe matricea 
de pixeli unde am setat culoarea de contur si de umplere pentru patrat 
si dreptunghi si culoarea de fundal pentru CANVAS.In cazul liniei,prima
data am implementat versiunea de algoritm Bresenham de la cerinta temei,
insa linia nu aparea,in schimb am implementat alta varianta.

	Pentru conturul cercului am implementat algoritmul intr-o clasa separata
(BresenhamCircle),luand cateva puncte ca referinta, din 45 in 45 de grade.

	Am avut grija ca dimensiunile cercului,in cazul in care ies din afara 
CANVAS-ului sa impun o limita in asa fel incat sa nu primesc eroare la 
compilare, la fel am procedat si pentru restul figurilor.

	Pentru umplerea formelor, a fost nevoie de aplicat FloodFill,pe care la 
fel, l-am implementat separat.Am ales implementarea cu o coada.Aici am 
tinut cont de faptul ca la colorarea unei forme,trebuie la un moment dat
sa ma opresc, in momentul in care ajung la imaginea de contur a formei.

	 In cazul in care inca sunt in interiorul conturului,pictez pixelii adiacenti
pixelului actual.

	Laturile rombului le-am realizat cu ajutorul celor 2 diagonale si a 
centrului.Am aflat cele 4 puncte pe care l-am notat cu South, North, 
West si East si apoi am trasat linia intre ele.In cazul poligonui am 
retinut toate punctele int-un vector(vector separat de abcise si ordonate)
si apoi am realizat legaturi intre ele.