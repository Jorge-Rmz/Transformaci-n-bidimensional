package Transformaciones;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Figura extends JFrame {

    double width, height;
    public float[][] matriz = {{600, 513, 1}, {830, 513, 1}, {830, 300, 1}, {600, 300, 1}};
    static GL gl;
    static GLU glu;

    public float[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(float[][] matriz) {
        this.matriz = matriz;
    }
    
    public Figura() {
        setTitle("Figura");
        //Instanciamos la clase Graphic
        GraphicListener listener = new GraphicListener();
        //Creamos el canvas
        GLCanvas canvas = new GLCanvas(new GLCapabilities());
        canvas.addGLEventListener(listener);
        getContentPane().add(canvas);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.getWidth();
        height = screenSize.getHeight();
    }

    public class GraphicListener implements GLEventListener {

        public void display(GLAutoDrawable arg0) {

            glu = new GLU();
            gl = arg0.getGL();

            //Establecer los parametros para la proyeccion
            gl.glMatrixMode(gl.GL_PROJECTION);

            gl.glBegin(GL.GL_POLYGON);

            gl.glColor3f(500, 200, 0);

            gl.glVertex2d(matriz[0][0], matriz[0][1]); // Top left
            gl.glVertex2d(matriz[1][0], matriz[1][1]);// Top Right
            gl.glVertex2d(matriz[2][0], matriz[2][1]);// Bottom Right
            gl.glVertex2d(matriz[3][0], matriz[3][1]);// Bottom Left
            gl.glEnd();
        }

        public void init(GLAutoDrawable arg0) {
            glu = new GLU();
            gl = arg0.getGL();
            gl.glClearColor(0, 0, 0, 0);
            //Establecer los parametros para la proyeccion
            gl.glMatrixMode(gl.GL_PROJECTION);

            glu.gluOrtho2D(0, width, 0, height);

        }

        public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {

        }

        public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {

        }

    }
}
