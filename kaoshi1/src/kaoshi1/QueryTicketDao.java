package kaoshi1;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class QueryTicketDao {

	protected Shell shell;
	private Table table;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			QueryTicketDao window = new QueryTicketDao();
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
		shell.setSize(625, 466);
		shell.setText("SWT Application");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 10, 605, 201);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn_6 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_6.setWidth(100);
		tblclmnNewColumn_6.setText("TID");
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("\u8F66\u6B21\u7F16\u53F7");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("\u8D77\u59CB\u7AD9");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("\u7EC8\u70B9\u7AD9");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("\u53D1\u8F66\u65F6\u95F4");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(100);
		tblclmnNewColumn_4.setText("\u786C\u5EA7\u4EF7\u683C");
		
		TableCursor tableCursor = new TableCursor(table, SWT.NONE);
		
		TableColumn tblclmnNewColumn_5 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_5.setWidth(100);
		tblclmnNewColumn_5.setText("\u8F6F\u5367\u4EF7\u683C");
		

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				table.removeAll();
				TicketDao tdao=new TicketDao();
				List<Map<String,Object>> list=tdao.query(
						text.getText(),
						text_1.getText(),
						text_2.getText(),
						text_3.getText(),
						text_4.getText());
				for(Map<String,Object>map:list){				
				TableItem tableItem = new TableItem(table, SWT.NONE);
				tableItem.setText(new String[]{
					""+map.get("TID"),
					""+map.get("TRAINNO"),	
					""+map.get("LEAVECITY"),	
					""+map.get("ARRIVECITY"),	
					""+map.get("LEAVETIME"),	
					""+map.get("SEATPRICE"),	
					""+map.get("BENDPRICE")
						
						});
				}
			}
		});
				
		btnNewButton.setBounds(73, 372, 192, 27);
		btnNewButton.setText("\u67E5\u8BE2");
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddTicketWin window = new AddTicketWin();
				window.open();
			}
		});
		button.setBounds(341, 375, 217, 20);
		button.setText("\u65B0\u589E");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(73, 232, 61, 17);
		lblNewLabel.setText("\u8D77\u59CB\u7AD9");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(176, 232, 84, 23);
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(73, 279, 61, 17);
		lblNewLabel_1.setText("\u7EC8\u70B9\u7AD9");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(176, 273, 84, 23);
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setText("\u53D1\u8F66\u65F6\u95F4");
		lblNewLabel_2.setBounds(73, 316, 61, 17);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(176, 310, 84, 23);
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setText("\u786C\u5EA7\u4EF7\u683C");
		lblNewLabel_3.setBounds(370, 232, 61, 17);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(445, 232, 84, 23);
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setText("\u8F6F\u5367\u4EF7\u683C");
		lblNewLabel_4.setBounds(370, 279, 61, 17);
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(445, 279, 84, 23);
	}
}


