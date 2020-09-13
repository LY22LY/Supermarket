package SupermarketCashRegister;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.bean.GoodSprivoder1;

import com.dao.DaoGongHuoUser;

public class GongHuoJpanel extends JPanel implements ActionListener, MouseListener {
	private JPanel jp_chaxun;
	private JPanel jp_guanli;
	private JTextField jt_guanjianzi;
	private JLabel jl_guanjianzi;
	private JButton jb_chaxun;
	private JLabel jl_mingcheng;
	private JLabel jl_dianhua;
	private JLabel jl_dizhi;
	private JLabel jl_lianxiren;
	private JTextField jt_mingcheng;
	private JTextField jt_dianhua;
	private JTextField jt_dizhi;
	private JTextField jt_lianxiren;
	private JButton jb_tianjia;
	private JButton jb_xiugai;
	private JButton jb_shanchu;
	private JScrollPane jsp_gonghuo;
	private DefaultTableModel model;
	private JTable jt_gonghuo;
	private ArrayList<GoodSprivoder1> list2;
	private DaoGongHuoUser daogh = new DaoGongHuoUser();

	public GongHuoJpanel() {
		initGUI();
	}

	private void initGUI() {

		this.setPreferredSize(new Dimension(730, 550));
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		// 查询
		{
			jsp_gonghuo = new JScrollPane();
			jsp_gonghuo.setBounds(5, 80, 700, 270);

			// 创建jtable模型
			// tablemap是接口
			// 构造方法三个参数，第一个null第二个是字符串数组
			model = new DefaultTableModel(null, new String[] { "供货商名称", "电话", "地址", "联系人" });

			// 创建列表
			jt_gonghuo = new JTable(model);

			jsp_gonghuo.setViewportView(jt_gonghuo);
			jt_gonghuo.addMouseListener(this);
			list2 = daogh.selectAll();
			if (list2.size() == 0) {

			} else {
				// 遍历集合，显示
				for (int i = 0; i < list2.size(); i++) {
					GoodSprivoder1 ghvoder = list2.get(i);
					String[] rowData = {  ghvoder.getGPName(), ghvoder.getGPPhone(),
							ghvoder.getGPSddress(), ghvoder.getGPLinkman() };
					model.addRow(rowData);
				}
			}
			jp_chaxun = new JPanel();
			jp_chaxun.setPreferredSize(new Dimension(725, 355));
			jp_chaxun.setLayout(null);
			jp_chaxun.setBorder(BorderFactory.createTitledBorder("供货商查询"));
			jl_guanjianzi = new JLabel("输入供货商名称或电话");
			jl_guanjianzi.setBounds(15, 30, 180, 30);

			jt_guanjianzi = new JTextField();
			jt_guanjianzi.setBounds(210, 25, 250, 30);
			jb_chaxun = new JButton();
			jb_chaxun.setText("查询");
			jb_chaxun.addActionListener(this);
			jb_chaxun.setBounds(510, 25, 60, 30);
			jp_chaxun.add(jb_chaxun);
			jp_chaxun.add(jl_guanjianzi);
			jp_chaxun.add(jt_guanjianzi);
			jp_chaxun.add(jsp_gonghuo);

			this.add(jp_chaxun, BorderLayout.NORTH);

		}
		// 下面那块
		{
			jp_guanli = new JPanel();
			jp_guanli.setPreferredSize(new Dimension(725, 130));
			jp_guanli.setBorder(BorderFactory.createTitledBorder("供货商管理"));
			jp_guanli.setLayout(null);

			jl_mingcheng = new JLabel("供货商名称:");
			jl_dianhua = new JLabel("联系电话:");
			jl_dizhi = new JLabel("供货商地址:");
			jl_lianxiren = new JLabel("联系人:");
			jt_mingcheng = new JTextField();
			jt_dianhua = new JTextField();
			jt_dizhi = new JTextField();
			jt_lianxiren = new JTextField();
			jb_tianjia = new JButton("添加供货商");
			jb_tianjia.addActionListener(this);
			jb_xiugai = new JButton("修改供货商");
			jb_xiugai.addActionListener(this);
			jb_shanchu = new JButton("删除供货商");
			jb_shanchu.addActionListener(this);
			jl_mingcheng.setBounds(20, 55, 80, 30);
			jt_mingcheng.setBounds(120, 55, 160, 30);
			jl_dizhi.setBounds(20, 105, 80, 30);
			jt_dizhi.setBounds(120, 105, 160, 30);
			jl_dianhua.setBounds(310, 55, 80, 30);
			jt_dianhua.setBounds(400, 55, 160, 30);
			jl_lianxiren.setBounds(310, 105, 80, 30);
			jt_lianxiren.setBounds(400, 105, 160, 30);
			jb_tianjia.setBounds(580, 55, 120, 35);
			jb_xiugai.setBounds(580, 105, 120, 35);
			jb_shanchu.setBounds(580, 155, 120, 35);
			jp_guanli.add(jl_mingcheng);
			jp_guanli.add(jl_dianhua);
			jp_guanli.add(jl_dizhi);
			jp_guanli.add(jl_lianxiren);
			jp_guanli.add(jt_mingcheng);
			jp_guanli.add(jt_dizhi);
			jp_guanli.add(jt_dianhua);
			jp_guanli.add(jt_lianxiren);
			jp_guanli.add(jb_tianjia);
			jp_guanli.add(jb_xiugai);
			jp_guanli.add(jb_shanchu);
			this.add(jp_guanli, BorderLayout.CENTER);

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		int row = jt_gonghuo.getSelectedRow();
		String GPName = jt_gonghuo.getValueAt(row, 0).toString();
		String GPPhone = jt_gonghuo.getValueAt(row, 1).toString();
		String GPSddress = jt_gonghuo.getValueAt(row, 2).toString();
		String GPLinkman = jt_gonghuo.getValueAt(row, 3).toString();
		// 通过id查询用户

		// 拿出查到用户的密码

		// 将四个数据放到右边的控件中
		jt_mingcheng.setText(GPName);
		jt_dianhua.setText(GPPhone);
		jt_dizhi.setText(GPSddress);
		jt_lianxiren.setText(GPLinkman);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o == jb_chaxun) {
			// 模糊查询之前清空表格的内容
			for (int i = model.getRowCount() - 1; i >= 0; i--) {
				model.removeRow(i);
			}

//获取查询信息
			String info = jt_guanjianzi.getText();
			if (info.equals("")) {
				// 查询的空里面为空显示所有数据
				list2 = daogh.selectAll();
				if (list2.size() == 0) {
					JOptionPane.showMessageDialog(null, "系统用户不存在");
				} else {
					// 遍历集合，显示

					for (int i = 0; i < list2.size(); i++) {
						GoodSprivoder1 ghvoder = list2.get(i);

						String[] rowData = { ghvoder.getGPName(), ghvoder.getGPPhone(), ghvoder.getGPSddress(),
								ghvoder.getGPLinkman() };
						model.addRow(rowData);
					}
				}
			} else {
				// 模糊查询

				list2 = daogh.selectByNameorPhone(info);
				if (list2.size() == 0) {
					for (int i = model.getRowCount() - 1; i >= 0; i--) {
						model.removeRow(i);
					}
					JOptionPane.showMessageDialog(null, "系统用户不存在");
				} else {
					// 遍历集合，显示
					for (int i = 0; i < list2.size(); i++) {
						GoodSprivoder1 ghvoder = list2.get(i);
						String[] rowData = { ghvoder.getGPName(), ghvoder.getGPPhone(), ghvoder.getGPSddress(),
								ghvoder.getGPLinkman() };
						model.addRow(rowData);
					}
				}
			}
		}
		if (o == jb_tianjia) {

			String GPName = jt_mingcheng.getText();
			String GPPhone = jt_dianhua.getText();
			String GPSddress = jt_dizhi.getText();
			String GPLinkman = jt_lianxiren.getText();

			if (GPName.equals("") || GPPhone.equals("") || GPLinkman.equals("")) {
				JOptionPane.showMessageDialog(null, "供货商姓名、电话或联系人不能为空");
			} else {
				// 判断id是否存在
				// 调用控制层的相关方法
				GoodSprivoder1 ghvoder = daogh.selectByGPName(GPName);
				if (ghvoder == null) {
					// id不存在
					GoodSprivoder1 newghvoder = new GoodSprivoder1(GPName, GPPhone, GPSddress, GPLinkman);
					boolean flag = daogh.insertUser(newghvoder);
					// 判断
					if (flag == true) {
						JOptionPane.showMessageDialog(null, "插入成功");

					} else {
						JOptionPane.showMessageDialog(null, "插入失败");
					}
				} else {// id存在

					JOptionPane.showMessageDialog(null, "id账号已经存在");
				}
			}
			for (int i = model.getRowCount() - 1; i >= 0; i--) {
				model.removeRow(i);
			}
			list2 = daogh.selectAll();
			for (int i = 0; i < list2.size(); i++) {
				GoodSprivoder1 ghvoder = list2.get(i);
				String[] rowData = { ghvoder.getGPName(), ghvoder.getGPPhone(), ghvoder.getGPSddress(),
						ghvoder.getGPLinkman() };
				model.addRow(rowData);
			}
		}
		if (o == jb_xiugai) {
			String GPName = jt_mingcheng.getText(); // 获取用户名
			String GPPhone = jt_dianhua.getText(); // 获取id
			String GPSddress = jt_dizhi.getText(); // 获取密码
			String GPLinkman = jt_lianxiren.getText();
			GoodSprivoder1 newghvoder = new GoodSprivoder1(GPName, GPPhone, GPSddress, GPLinkman);
			int count = daogh.change(newghvoder);
			if (count > 0) {
				JOptionPane.showMessageDialog(null, "修改成功");
			} else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
			for (int i = model.getRowCount() - 1; i >= 0; i--) {
				model.removeRow(i);
			}
			list2 = daogh.selectAll();
			for (int i = 0; i < list2.size(); i++) {
				GoodSprivoder1 ghvoder = list2.get(i);
				String[] rowData = { ghvoder.getGPName(), ghvoder.getGPPhone(), ghvoder.getGPSddress(),
						ghvoder.getGPLinkman() };
				model.addRow(rowData);
			}
		}
		if (o == jb_shanchu) {

			String GPName = jt_mingcheng.getText();// 获取id

			int count = daogh.shanchu(GPName);
			if (count > 0) {
				JOptionPane.showMessageDialog(null, "删除成功");
			} else {
				JOptionPane.showMessageDialog(null, "删除失败");
			}
			for (int i = model.getRowCount() - 1; i >= 0; i--) {
				model.removeRow(i);
			}
			list2 = daogh.selectAll();
			for (int i = 0; i < list2.size(); i++) {
				GoodSprivoder1 ghvoder = list2.get(i);
				String[] rowData = { ghvoder.getGPName(), ghvoder.getGPPhone(), ghvoder.getGPSddress(),
						ghvoder.getGPLinkman() };
				model.addRow(rowData);
			}
		}
	}
}
