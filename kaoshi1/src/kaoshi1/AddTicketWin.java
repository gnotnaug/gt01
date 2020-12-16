package kaoshi1;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class AddTicketWin {

	protected Shell shell;
	private Text text;
	private Label lblNewLabel_1;
	private Label lblNewLabel_2;
	private Label lblNewLabel_3;
	private Label lblNewLabel_4;
	private Label lblNewLabel_5;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AddTicketWin window = new AddTicketWin();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 395);
		shell.setText("SWT Application");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(46, 36, 61, 17);
		lblNewLabel.setText("\u8F66\u6B21");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(150, 33, 142, 23);
		
		lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setText("\u8D77\u59CB\u7AD9");
		lblNewLabel_1.setBounds(46, 77, 61, 17);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(150, 77, 142, 23);
		
		lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setText("\u7EC8\u70B9\u7AD9");
		lblNewLabel_2.setBounds(46, 111, 61, 17);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(150, 111, 142, 23);
		
		lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setText("\u51FA\u53D1\u65F6\u95F4");
		lblNewLabel_3.setBounds(46, 147, 61, 17);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(150, 141, 142, 23);
		
		lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setText("\u786C\u5EA7\u4EF7\u683C");
		lblNewLabel_4.setBounds(46, 187, 61, 17);
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(150, 187, 142, 23);
		
		lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setText("\u8F6F\u5367\u4EF7\u683C");
		lblNewLabel_5.setBounds(46, 223, 61, 17);
		
		text_5 = new Text(shell, SWT.BORDER);
		text_5.setBounds(150, 223, 142, 23);
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				TicketDao tdao=new TicketDao();
				Map<String,Object>map=new HashMap<>();
				map.put("TRAINNO", text.getText());
				map.put("LEAVECITY", text_1.getText());
				map.put("ARRIVECITY", text_2.getText());
				map.put("LEAVETIME", text_3.getText());
				map.put("SEATPRICE", text_4.getText());
				map.put("BENDPRICE", text_5.getText());
				tdao.insert(map);
			}
		});
		button.setBounds(129, 288, 223, 27);
		button.setText("\u4FDD\u5B58");

	}
}
