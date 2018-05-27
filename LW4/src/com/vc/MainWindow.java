package com.vc;

import com.model.Road;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** This class is view - controller part of architectural pattern MVC.
 */
public class MainWindow {
    private Road road;

    /**
     * This method creates simple AWT GUI application.
     *
     * @param road describes the model of MVC
     */
    public MainWindow(Road road) {
        this.road = road;
        ExecutorService exec = Executors.newSingleThreadExecutor();

        final Display display = new Display();
        final Shell shell = new Shell(display);

        GridLayout layout = new GridLayout(2,false);
        shell.setLayout(layout);

        Button start = new Button(shell, SWT.PUSH);
        start.setText("Поехали");

        Button stop = new Button(shell, SWT.PUSH);
        stop.setText("Стоп машина");

        Label labelCount = new Label(shell, SWT.NONE);
        labelCount.setText("Количество нарушений");

        Composite composite = new Composite(shell, SWT.TOP);
        composite.setLayout(layout);
        Text textCount = new Text(composite, SWT.FILL);

        Label labelSpeed = new Label(shell, SWT.NONE);
        labelSpeed.setText("Максимальная скорость");

        composite = new Composite(shell, SWT.TOP);
        composite.setLayout(layout);
        Text textSpeed = new Text(composite, SWT.FILL);

        GridData data = new GridData(SWT.FILL, SWT.FILL, false, false);
        data.horizontalSpan = 1;
        data.verticalSpan = 1;
        data.widthHint = 170;
        start.setLayoutData(data);
        stop.setLayoutData(data);

        data = new GridData(SWT.FILL, SWT.FILL, false, false );
        data.horizontalSpan = 1;
        data.verticalSpan = 1;
        data.widthHint = 170;
        labelCount.setLayoutData(data);
        textCount.setLayoutData(data);

        data = new GridData(SWT.FILL, SWT.FILL, false, false);
        data.horizontalSpan = 1;
        data.widthHint = 170;
        data.verticalSpan = 1;
        labelSpeed.setLayoutData(data);
        textSpeed.setLayoutData(data);

        start.addListener(SWT.Selection, new Listener() {

            /**
             * Thread of the road is perform.
             * @param event not used
             * @see ExecutorService
             */
            @Override
            public void handleEvent(Event event) {
                exec.execute(road);
            }
        });

        stop.addListener(SWT.Selection, new Listener() {

            /**
             * Thread of the road is shut down.
             * @param event not used
             * @see ExecutorService
             */
            @Override
            public void handleEvent(Event event) {
                exec.shutdown();
            }
        });

        shell.pack();
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
                if (road.getCounterForMessage() == 50 && road.getCarQueue().size() <= 50) {
                    road.setCounterForMessage(0);
                    textSpeed.setText(String.valueOf(road.showMaxSpeed()));
                    textCount.setText(String.valueOf(road.showOffence()));
                }
            }
        }
        display.dispose();
    }

}
