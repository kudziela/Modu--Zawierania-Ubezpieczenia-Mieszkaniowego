clear all; close all; clc;
I = imread('image1.jpg');
imshow(I), title('Original')
level = graythresh(I);
AAA = im2bw(I, level);
figure, imshow(AAA);
Suma= sum(sum(AAA));
disp(Suma);

Suma_all = sum(sum(I));

D = bwmorph(AAA, 'dilate');
imshow(D);
title('dylatacja');
DD= im2bw(D, level);
figure, imshow(DD);
Suma88= sum(sum(DD));
disp(Suma88);

E = bwmorph(AAA, 'erode');
imshow(E);
title('erozja');
EE= im2bw(E, level);
figure, imshow(EE);
Suma888= sum(sum(EE));
disp(Suma888);

O = bwmorph(AAA, 'open');
imshow(O);
title('otwarcie');
OO = im2bw(O, level);
figure, imshow(OO);
Suma8888= sum(sum(OO));
disp(Suma8888);

C = bwmorph(AAA, 'close');
imshow(C);
title('zamkniecie');
CC = im2bw(C, level);
figure, imshow(CC);
Suma88888= sum(sum(CC));
disp(Suma88888);

disp(suma_all);

