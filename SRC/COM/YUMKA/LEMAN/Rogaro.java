package com.yumka.leman;

import com.yumka.leman.ui.windows.InternalFrame;
import com.yumka.leman.ui.*;
import javax.swing.JDesktopPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * <p>Title: Sistema de Gesti&oacute;n de Calidad</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Equipo X</p>
 * @author <a href="mailto:yumkasoftware@prodigy.net.mx">Domingo Su&aacute;rez Torres </a>
 * @version 1.0
 */

public class Rogaro extends InternalFrame {
  JTabbedPane tabbedPane;
  public Rogaro(JDesktopPane p0, JFrame p2, boolean p3) {
    super(p0, "Información de Rogaro", p2, true);
    JEditorPane htmlViewer = null;
    tabbedPane = new JTabbedPane();
    try {
      htmlViewer = new JEditorPane("text/html", "");
      htmlViewer.setEditable(false);
      htmlViewer.setFocusable(false);

      StringBuffer html = new StringBuffer();
      html.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"><html><head><title>Untitled Document</title></head><body>");
      html.append("1. LINEAMIENTOS GENERALES<p>Visi&oacute;n:</p><p>Llegar a ser la mejor cadena de Caf&eacute; en M&eacute;xico. </p><p>Misi&oacute;n:</p>");
      html.append("<p>Siendo nuestro prop&oacute;sito llegar a ser una compa&ntilde;&iacute;a que   ofrecer al consumidor bebidas preparadas a base de Caf&eacute; de altura y un  producto terminado de calidad tanto a nivel nacional como internacional. Procurar ");
      html.append("  el desarrollo de nuestro personal y la seguridad de una persistencia a nuestros   proveedores. Para cumplir con estas expectativas, Rogaro S.A adopta el sistema   de calidad ISO 9001:2000, como base para la mejora continua.</p><p>Pol&iacute;tica</p>");
      html.append("<p>Satisfacer las necesidades y expectativas de nuestros clientes ofreci&eacute;ndoles   bebidas preparadas a base de caf&eacute; y un producto terminado de calidad   a base de la mejora continua de nuestros servicios, trabajando en la prevenci&oacute;n   de no conformidades y adelant&aacute;ndose a la aparici&oacute;n de las mismas,   dando siempre una respuesta r&aacute;pida y favorable ante cualquier perjuicio   causado al cliente.</p>");
      html.append("<p>Valores: <br>  1. Respeto a la persona humana. <br>  2. Gerencia permanente por resultados. <br>  3. Honestidad y puntualidad. <br>  4. B&uacute;squeda constante de valor agregado. <br>  5. Vocaci&oacute;n de servicio y solidaridad en el trabajo. <br>  6. Impulso al trabajo en equipo. <br>  7. Cumplimiento de compromiso. <br>  8. imparcialidad, <br>  9. neutralidad, <br>  10. independencia, <br>  11. unidad <br>  12. universalidad.<br>  13. &Eacute;tica<br>  14. Integridad<br>  15. Sentido Emprendedor</p><p>Objetivos:</p>");
      html.append("<p>1. Ofrecer un producto de alta calidad, que brinde una ventaja competitiva.<br>  2. Ofrecer los m&aacute;s completos servicios de una cadena de caf&eacute; en   M&eacute;xico.<br>  3. Estamos orientados a cubrir las necesidades de nuestros consumidores.<br>  4. Mantener costos m&aacute;s bajos sobre la competencia.<br>  5. Satisfacer la demanda de nuestros clientes, brind&aacute;ndoles servicios   de calidad. <br>");
      html.append("  6. Fortalecer en la cultura organizacional de la instituci&oacute;n la creatividad,   el cambio de actitud y valores, generando una organizaci&oacute;n con mayor   valor. <br>  Valores:<br>  Servicio: &#8220;Trascender a trav&eacute;s de dar lo mejor de nosotros a nuestros   clientes, l&iacute;deres, proveedores y sociedad, superando sus expectativas.   Ofrecer atenci&oacute;n esmerada, variedad, calidad en productos y servicios   con los mejores precios. Dejar un legado en las comunidades a las cuales impactamos&#8221;.<br>  &#8226; Calidad en productos<br>  &#8226; Calidad en servicio<br>  &#8226; Precios bajos<br>");
      html.append("  &#8226; Compromiso con la comunidad<br>  &#8226; Servicio social<br>  Sinergia: &#8220;Un equipo unido que genera una fuerza superior, donde el resultado   del trabajo en conjunto es mejor que el esfuerzo individual. Implica armon&iacute;a,   respeto, compromiso, apertura, integraci&oacute;n y comunicaci&oacute;n efectiva.   Es tener mentalidad Ganar/Ganar y celebrar nuestras diferencias&#8221;.<br>  &#8226; Trabajo en equipo <br>  &#8226; Unidad de Familia<br>  &#8226; Sentido de pertenencia<br>  &#8226; Comunicaci&oacute;n<br>  &#8226; Confianza<br>  &#8226; Armon&iacute;a<br>  &#8226; Sin fronteras<br>  &#8226; Cooperaci&oacute;n<br>  &#8226; Mente maestra<br>  &#8226; Conexi&oacute;n <br>  &#8226; Humildad<br>  &#8226; Integraci&oacute;n <br>  &#8226; Compa&ntilde;erismo<br>  &#8226; Respeto<br>  &#8226; Aceptaci&oacute;n y valoraci&oacute;n de diferencias<br>  &#8226; Amistad<br>  &#8226; Liderazgo<br>  &#8226; Ganar/ganar <br>");
      html.append("&#8226; Preocupaci&oacute;n por los dem&aacute;s<br>  &#8226; Orgullo de trabajar en el Globo<br>  &#8226; Empat&iacute;a<br>  &#8226; Cooperaci&oacute;n <br>");
      html.append("  Mejoramiento continuo: &#8220;Estado de alerta que nos permite detectar oportunidades   para hacerlo cada d&iacute;a mejor. Desarrollo constante de nuevas habilidades,   destrezas y conocimientos. Superarnos y buscar caminos que nos permitan conformar   un equipo humano feliz y con vidas balanceadas. En este sentido, nos declaramos   aprendices permanentes en lo personal y profesional&#8221;.<br>  &#8226; Excelencia<br>  &#8226; Tecnolog&iacute;a <br>  &#8226; Estad&iacute;sticas<br>");
      html.append("  &#8226; Progreso<br>  &#8226; Deseos de triunfo<br>  &#8226; Superaci&oacute;n<br>  &#8226; Perseverancia<br>  &#8226; Actitud de pensar siempre c&oacute;mo hacerlo mejor<br>  &#8226; Crecimiento personal y profesional<br>  &#8226; Educaci&oacute;n<br>  &#8226; Disposici&oacute;n al cambio<br>  &#8226; Reconocimiento<br>  &#8226; Ser los mejores<br>  &#8226; Convertir todos nuestros servicios y departamentos en los N&ordm; 1   y N&ordm; 2 del mercado <br>  &#8226; Tener a los mejores<br>  &#8226; Esp&iacute;ritu emprendedor<br>  &#8226; Cambio<br>  &#8226; Romper paradigmas<br>  &#8226; Copiar las buenas ideas<br>  &#8226; Alcanzar metas<br>  &#8226; Detectar y superar debilidades <br>");
      html.append("  Integridad: &#8220;Congruencia entre pensamiento, palabra y acci&oacute;n. Honestidad   y transparencia en nuestros actos. Respeto a las personas, a la sociedad y al   ambiente. Humildad para reconocer nuestros errores. Ser justos y responsables&#8221;.<br>  &#8226; Balance<br>  &#8226; Honestidad<br>  &#8226; Respeto a las personas<br>  &#8226; Congruencia<br>  &#8226; Confiabilidad<br>  &#8226; Credibilidad<br>  &#8226; Rectitud<br>  &#8226; Hacer lo que se dice<br>  &#8226; Transparencia<br>  &#8226; Relaci&oacute;n ganar/ganar<br>  &#8226; Equidad/ Justicia<br>  &#8226; Cumplimiento de promesas<br>  &#8226; Saber decir &#8220;no&#8221; <br>  &#8226; Lealtad<br>  &#8226; Desarrollo integral de las personas<br>  &#8226; El valor de la palabra<br>  &#8226; Saber decir &#8220;No s&eacute;&#8221;<br>  <br>");
      html.append("  Alegr&iacute;a: &#8220;Deseo, fe y pasi&oacute;n como energ&iacute;a que nos   mueve al logro de nuestras metas, disfrutando lo que hacemos&#8221;.<br>  &#8226; Optimismo <br>  &#8226; Disfrute<br>  &#8226; Humor<br>  &#8226; Dicha<br>  &#8226; Armon&iacute;a<br>  &#8226; Positivismo<br>  Innovaci&oacute;n: &#8220;Desarrollar nuevas maneras de pensar y crear formas   distintas de hacer las cosas. Ser pioneros. Estimular la creatividad y el esp&iacute;ritu   emprendedor. Diferenciarnos&#8221;.<br>  &#8226; Ruptura de paradigmas<br>  &#8226; Cambio<br>  &#8226; Creatividad<br>  &#8226; Esp&iacute;ritu emprendedor<br>");
      html.append("  Corporaci&oacute;n de Clase mundial: Capacidad de competir en t&eacute;rminos   de servicio, eficiencia y calidad con los mejores del mundo. <br>  Objetivos:<br>  &#8226; Ofrecer los mejores productos con la m&aacute;s alta calidad. <br>  &#8226; Estamos orientados a cubrir las necesidades m&aacute;s exigentes de   nuestros clientes.<br>  &#8226; Ofrecer un precio accesible a nuestros consumidores<br>  &#8226; Promover eficientemente nuestros productos destacando claramente las   ventajas y beneficios que ofrecen a nuestros consumidores.</p><p>Estrategias:</p><p>&#8226; Adquirir nuestra materia prima con proveedores confiables.<br>  &#8226; Hacer encuestas con nuestros clientes, acerca de la calidad de nuestros   productos.<br>");
      html.append("  &#8226; Elaborar planes para descuentos y promociones mensuales.<br>  &#8226; Anunciarnos en los medios de comunicaci&oacute;n m&aacute;s utilizados.</p><p><br>  Productos que elabora</p><p>Pasteles:</p><p>Sal&oacute;n </p><p>Descripci&oacute;n: <br>  Delicioso pastel de Chocolate embebido con jarabe marrasquino, relleno de crema   de chocolate y avellana, decorado con crema ganache y esferas de chocolate.</p><p>Castellano </p><p>Descripci&oacute;n: <br>  Delicioso pastel de nuez embebido con jarabe de ron y relleno de crema elaborada   con nuez, chocolate de leche y crema pastelera. Decorado con una exquisita salsa   de chocolate, nuez entera y trozos de chocolate amargo.</p><p>Crocante </p>");
      html.append("<p>Descripci&oacute;n: <br>  Delicioso pastel de vainilla, relleno de crema chantilly al jerez, decorado   con nougat de almendra y cerezas.</p><p>Strawberry </p><p>Descripci&oacute;n: <br>  Exquisito pastel de vainilla, relleno y decorado con crema chantilly y fresas   frescas.</p><p>Mediterr&aacute;neo</p><p>Descripci&oacute;n: <br>  Delicioso pastel de caf&eacute;, relleno de crema chantilly al caf&eacute;,   decorado con hojuelas de almendra tostada.</p><p>Tequila </p><p>Descripci&oacute;n: <br>  Delicioso pastel de vainilla con jarabe de tequila lim&oacute;n, relleno de   mousse de lim&oacute;n tequila, decorado con crema de mantequilla, jalea neutra,   ralladura de cascara de lim&oacute;n, escritura de chocolate y merengue cocido   en trozos.</p><p>Mil Hojas Avellana </p><p>Descripci&oacute;n: <br>  Exquisito pastel de crujiente pasta hojaldrada y crema de avellana, decorado   con peque&ntilde;os esferas de hojaldre y espolvoreado con az&uacute;car glass.</p>");
      html.append("<p>Capuchino </p><p>Descripci&oacute;n: <br>  Exquisito pastel de caf&eacute;. Compuesto de biscuit de caf&eacute; embebido   en jarabe del mismo sabor con delicioso mousse capuchino, rodeado con soleta   suave sabor caf&eacute; y decorado con crema chantilly y canela simulando la   espuma del caf&eacute; capuchino.</p><p>Tiramiz&uacute; </p><p>Descripci&oacute;n: <br>  Pastel elaborado con un exquisito pan de caf&eacute;, ba&ntilde;ado con jarabe   del mismo sabor, relleno y cubierto con una crema de queso mascarpone y una   mezcla especial de licores. Rodeado con una soleta de vainilla con trozos de   chocolate y decorado con finas &quot;rajas&quot; de chocolate</p><p>Mil Hojas Chantilly </p><p>Descripci&oacute;n: <br>  Exquisito pastel de crujiente pasta hojaldrada y crema chantilly, decorado con   aritos de hojaldre y espolvoreado con az&uacute;car glass.</p>");
      html.append("<p>Amaretino </p><p>Descripci&oacute;n: <br>  Delicioso pastel de chocolate con trocitos de nuez, relleno de crema chantilly   al amareto, decorado con granillo de chocolate.</p><p>Especial Tres Leches </p><p>Descripci&oacute;n: <br>  Delicioso pastel de vainilla impregnado de una mezcla de tres tipos de leche,   decorado con crema chantilly.</p><p>Truffa </p><p>Descripci&oacute;n: <br>  Exquisito pastel, elaborado con pasta sable&eacute; (pasta de consistencia galletosa),   rellena de miel maple, nuez en trozo, una capa de pan de chocolate embebido   en jarabe de ron y cubierta con suave crema de chocolate amargo. espolvoreado   de cocoa y laja de chocolate.</p><p>Mousse de Mango </p><p>Descripci&oacute;n: <br>  Exquisito pastel de vainilla, relleno de yogurt de mango, decorado con mermelada   de mango</p><p>Tarta de Frutas </p><p>Descripci&oacute;n: <br>  Suculenta tarta de pasta sucree, rellena con crema de almendras, decorada con   frutas de temporada surtidas (durazno,kiwi,uvas,fresa y zarzamora)</p><p>Carrot Cake </p><p>Descripci&oacute;n: <br>  Delicioso pastel de zanahoria, relleno con coco, nuez, y pasas, decorado con   queso crema y nuez en trozo.</p><p>Bocadillos</p><p>Petit Four de Crema </p><p>Descripci&oacute;n: <br>  Choux de Vainilla, Choux de Chocolate, Eclair de Caf&eacute;, Ecleir de Chocolate,   Mokka Miniatura, Tarta de Fresa. </p>");
      html.append("<p>Petit Four de Frutas </p>            <p>Descripci&oacute;n: <br>              Petit four de Zaramora o Frambuesa, Petit Four de Fresa, Petit Four de Crema               de Chocolate, Petit Four de Kiwi, Petit Four de Pi&ntilde;a y Cereza.</p>            <p>Botana Mexicana </p>            <p>Descripci&oacute;n: <br>              Minibolillo con Chorizo, Telerita con Jam&oacute;n, Hojaldra con Mole, Rollo               de Carne, Bollito con At&uacute;n, Miniaborigen con Ensalada de Pollo. </p>            <p>Bocadillos Finos </p>            <p>Descripci&oacute;n: <br>              Canasta de Queso Doble Crema y Pimienta, Tartaleta de Jam&oacute;n, Canap&eacute;               de Pat&eacute;, Canap&eacute; de Queso Amarillo, Canap&eacute; de Salami Ahumado,               Canap&eacute; de Jam&oacute;n con Mostaza</p>            <p>Bocadillo Extra Fino </p>            <p>Descripci&oacute;n: <br>              Tartaleta de Cangrejo, Canap&eacute; de Osti&oacute;n Ahumado, Canap&eacute;               de Caviar Rojo y Negro, Canastilla de Queso Roquefort, Canastailla de Queso               Doble crema, Canap&eacute; de Salami Ahumado.</p>            <p></p>            <p></p>            <p></p>");
      html.append("<p><br>  2. POL&Iacute;TICA DE CALIDAD<br>  &#8226; Para Coffee House la calidad es tan importante como el cliente<br>  &#8226; Trabajo con esp&iacute;ritu de equipo. <br>  &#8226; Producci&oacute;n a tiempo y de alta calidad.<br>  &#8226; Satisfacci&oacute;n total del cliente.<br>  &#8226; Llegara a ser una de las tiendas de caf&eacute; gourmet l&iacute;der   en el mundo.<br>  &#8226; Satisfacer las necesidades y expectativas de nuestros usuarios, buscando   permanentemente el crecimiento de la calidad de nuestras tiendas a trav&eacute;s   de un control de calidad adecuado.<br>  &#8226; Dotar a Coffee House de los recursos humanos y t&eacute;cnicos necesarios,   para asegurar la calidad en la prestaci&oacute;n de los servicios con los requisitos   establecidos. <br>  &#8226; Crear un clima favorable a la promoci&oacute;n de la calidad en el seno   de Coffee House, formando y motivando al personal en relaci&oacute;n con la   calidad y el trabajo en equipo, que permita el desarrollo profesional y personal   de todos sus miembros y la consecuci&oacute;n de la calidad requerida. <br>  &#8226; Asegurar la revisi&oacute;n continua del Sistema de Aseguramiento de   la Calidad, a trav&eacute;s de la realizaci&oacute;n de Auditor&iacute;as internas   de calidad, que permitan una revisi&oacute;n cr&iacute;tica y faciliten la mejora   del mismo. <br>");
      html.append("  &#8226; Buscar, de manera continua, la satisfacci&oacute;n de nuestros clientes   trabajando en la prevenci&oacute;n de no conformidades y adelant&aacute;ndose   a la aparici&oacute;n de las mismas, dando siempre una respuesta r&aacute;pida   y favorable ante cualquier perjuicio causado al cliente. <br>  &#8226; Desarrollar en nuestros empleados aquellas destrezas que permitan la   delegaci&oacute;n de responsabilidades y el autocontrol en sus actividades.   <br>  &#8226; Conseguir la satisfacci&oacute;n total del cliente, asegurando y manteniendo   la confianza del mismo mediante el cumplimiento en la prestaci&oacute;n de nuestro   servicio y la mejora continua, obtenida a trav&eacute;s del compromiso de Coffee   House con la Calidad. <br>  &#8226; Contribuir con el desarrollo social a trav&eacute;s de la generaci&oacute;n   de empleo.<br>  &#8226; Capacitar de manera continua al personal, t&eacute;cnico y administrativo   con el objetivo de lograr su desarrollo personal y profesional.<br>  &#8226; Para Coffee House perfeccionar todos los d&iacute;as m&aacute;s aun   el nivel de satisfacci&oacute;n de nuestros Clientes, y evaluar el grado de   atenci&oacute;n, es necesario que nosotros obtengamos opiniones relacionadas   a nuestros productos y servicios.</p><p></p><p></p><p></p></body></html>");





      htmlViewer.setText(html.toString());
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }

    Container cp = this.getContentPane();
    cp.setLayout(new BorderLayout());
    JButton cerrar = new JButton("Cerrar");
    cerrar.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
               dispose();
             }
           });
    this.tabbedPane.addTab("Información", new JScrollPane(htmlViewer));
    JLabel carta = new JLabel();
    JLabel organigrama = new JLabel();
    JLabel matriz01 = new JLabel();
    JLabel matriz02 = new JLabel();
    JLabel matriz03 = new JLabel();
    JLabel matriz04 = new JLabel();

    //JLabel procesos = new JLabel();
    JLabel diagramas = new JLabel();

    carta.setIcon(ResourceLoader.getImageIcon("Carta.PNG"));
    organigrama.setIcon(ResourceLoader.getImageIcon("organigrama.PNG"));
    diagramas.setIcon(ResourceLoader.getImageIcon("diagramas.JPG"));

    matriz01.setIcon(ResourceLoader.getImageIcon("matriz001.gif"));
    matriz02.setIcon(ResourceLoader.getImageIcon("matriz002.gif"));
    matriz03.setIcon(ResourceLoader.getImageIcon("matriz003.gif"));
    matriz04.setIcon(ResourceLoader.getImageIcon("matriz004.gif"));
    //procesos.setIcon(ResourceLoader.getImageIcon("procesos.PNG"));

    JPanel matriz = new JPanel();
    matriz.setLayout(new GridLayout(4, 1));
    matriz.add(matriz01);
    matriz.add(matriz02);
    matriz.add(matriz03);
    matriz.add(matriz04);

    JPanel dia = new JPanel();
    //dia.setLayout(new GridLayout(2, 1));
    //dia.add(procesos);
    dia.add(diagramas);

    this.tabbedPane.addTab("Organigrama", new JScrollPane(organigrama));
    this.tabbedPane.addTab("Matriz de Responsabilidades", new JScrollPane(matriz));
    this.tabbedPane.addTab("Procesos", new JScrollPane(dia));


    this.tabbedPane.addTab("Carta", new JScrollPane(carta));

    cp.add(this.tabbedPane, BorderLayout.CENTER);
    htmlViewer.setCaretPosition(0);
    cp.add(cerrar, BorderLayout.SOUTH);

  }
}
