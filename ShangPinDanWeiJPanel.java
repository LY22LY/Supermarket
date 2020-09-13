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

import com.bean.DanWei;
import com.bean.ShopVip;
import com.dao.DaoDanWei;

public class ShangPinDanWeiJPanel extends JPanel implements ActionListener, MouseListener {

	private JPanel jp_danwei;
	private JLabel jl_danwei;
	private JTextField jt_danwei;
	private JButton jb_chaxun;
	private JPanel jp_anniu;
	private JButton jb_tianjia;
	private JButton jb_xiugai;
	private JButton jb_shanchu;
	private JLabel jl_bianhao;
	private JLabel jl_mingcheng;
	private JTextField jt_bianhao;
	private JTextField jt_mingcheng;
	private DaoDanWei daodsdDanwei = new DaoDanWei();
	private ArrayList<DanWei> list;
	private DefaultTableModel model;
	private JTable jta_danwei;

	public ShangPinDanWeiJPanel() {
		initGUI();
	}

	// 界面初始化
	public void initGUI() {
		// 设置卡片大小
		this.setPreferredSize(new Dimension(730, 255));
		BorderLayout bl = new BorderLayout();
		this.setLayout(bl);

		// 商品单位子面板
		{
			jp_danwei = new JPanel();
			jp_danwei.setPreferredSize(new Dimension(350, 240));
			jp_danwei.setLayout(null);
			// 设置边框
			jp_danwei.setBorder(BorderFactory.createTitledBorder("商品单位"));
			this.add(jp_danwei, BorderLayout.WEST);
			// 单位名称一行
			jl_danwei = new JLabel();
			jl_danwei.setText("单位名称：");
			jl_danwei.setBounds(30, 80, 60, 20);
			jp_danwei.add(jl_danwei);

			jt_danwei = new JTextField();
			jt_danwei.setBounds(110, 80, 120, 25);
			jp_danwei.add(jt_danwei);

			jb_chaxun = new JButton();
			jb_chaxun.setText("查询");
			jb_chaxun.setBounds(250, 80, 60, 25);
			jp_danwei.add(jb_chaxun);
			jb_chaxun.addActionListener(this);
		}
		// 设置单位编号列表
		{
			JScrollPane jsc_danwei = new JScrollPane();
			jsc_danwei.setBounds(50, 140, 240, 200);
			jp_danwei.add(jsc_danwei);

			model = new DefaultTableModel(null, new String[] { "编号", "单位名称" });
			jta_danwei = new JTable(model);
			jta_danwei.addMouseListener(this);
			jsc_danwei.setViewportView(jta_danwei);

			// 查询单位全部数据
			for (int i = model.getRowCount() - 1; i >= 0; i--) {
				model.removeRow(i);
			}
			list = daodsdDanwei.selectAll();
			if (list.size() == 0) {
				// 数据表是空的
				JOptionPane.showMessageDialog(null, "系统用户不存在");

			} else {
				// 数据表不是空的，遍历集合，将数据拿出，放到表格中
				for (int i = 0; i < list.size(); i++) {
					DanWei danwei = list.get(i);// 拿出一个user对象
					// 将列表中的编号，单位名称组成一个对象数组
					String[] rowData = { String.valueOf(danwei.getGUId()), danwei.getGUName() };
					model.addRow(rowData);
				}
			}
		}

		// 按钮组

		jp_anniu = new JPanel();
		jp_anniu.setLayout(null);
		jp_anniu.setPreferredSize(new Dimension(350, 240));
		this.add(jp_anniu, BorderLayout.EAST);
		jb_tianjia = new JButton();
		jb_tianjia.setText("添加商品");
		jb_tianjia.setBounds(50, 220, 120, 25);
		jp_anniu.add(jb_tianjia);
		jb_tianjia.addActionListener(this);

		jb_xiugai = new JButton();
		jb_xiugai.setText("修改商品");
		jb_xiugai.setBounds(50, 270, 120, 25);
		jp_anniu.add(jb_xiugai);
		jb_xiugai.addActionListener(this);

		jb_shanchu = new JButton();
		jb_shanchu.setText("删除商品");
		jb_shanchu.setBounds(50, 320, 120, 25);
		jp_anniu.add(jb_shanchu);
		jb_shanchu.addActionListener(this);

		jl_bianhao = new JLabel();
		jl_bianhao.setText("编号：");
		jl_bianhao.setBounds(20, 50, 120, 25);
		jp_anniu.add(jl_bianhao);

		jt_bianhao = new JTextField();
		jt_bianhao.setBounds(100, 50, 120, 25);
		jp_anniu.add(jt_bianhao);

		jl_mingcheng = new JLabel();
		jl_mingcheng.setText("单位名称：");
		jl_mingcheng.setBounds(20, 135, 120, 25);
		jp_anniu.add(jl_mingcheng);

		jt_mingcheng = new JTextField();
		jt_mingcheng.setBounds(100, 135, 120, 25);
		jp_anniu.add(jt_mingcheng);

	}

	/*
	 * 单位按钮操作
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o == jb_chaxun) {

			// 清空表格数据集合中的内容
			for (int i = model.getRowCount() - 1; i >= 0; i--) {
				model.removeRow(i);
			}

			// 获取查询信息
			String info = jt_danwei.getText();

			// 如果info是空的，显示所有结果；如果不是空，那就模糊查询
			if (info.equals("")) {
				// 表格中显示所有数据

				// 查询全部danwei数据
				list = daodsdDanwei.selectAll();

				if (list.size() == 0) {
					// 数据表是空的
					JOptionPane.showMessageDialog(null, "系统用户不存在");

				} else {
					// 数据表不是空的，遍历集合，将数据拿出，放到表格中
					for (int i = 0; i < list.size(); i++) {
						DanWei danwei = list.get(i);// 拿出一个danwei对象
						// 将列表中的bianhao,mingcheng组成一个对象数组
						String[] rowData = { String.valueOf(danwei.getGUId()), danwei.getGUName() };
						model.addRow(rowData);
					}
				}

			} else {
				// 模糊查询
				list = daodsdDanwei.selectBynameOrId(info);

				if (list.size() == 0) {
					// 数据表是空的
					JOptionPane.showMessageDialog(null, "系统用户不存在");

				} else {
					// 数据表不是空的，遍历集合，将数据拿出，放到表格中
					for (int i = 0; i < list.size(); i++) {
						DanWei danwei = list.get(i);// 拿出一个danwei对象
						// 将列表中的bianhao,mingcheng组成一个对象数组
						String[] rowData = { String.valueOf(danwei.getGUId()), danwei.getGUName() };
						model.addRow(rowData);
					}
				}
			}
		}

		if (o == jb_tianjia) {
			// 1.获取用户信息

			String guid = jt_bianhao.getText();// 获取编号
			String guname = jt_mingcheng.getText();// 获取单位名称

			// 2.判断bianhao,danweimingcheng，是否为空
			if (guid.equals("") || guname.equals("")) {
				JOptionPane.showMessageDialog(null, "编号，单位名称不能为空");
			} else {
				// 3.判断id是否存在，存在，提示用户；不存在，可以插入
				DanWei id = daodsdDanwei.selectById(guid);

				if (id == null) {
					// 4.如果id不存在，进行添加操作
					DanWei newuUser = new DanWei(Integer.parseInt(guid), guname);

					boolean flag = daodsdDanwei.insertDanwei(newuUser);
					flash();
					// 判断flag值，是否插入成功
					if (flag == true) {
						JOptionPane.showMessageDialog(null, "插入成功");
					} else {
						JOptionPane.showMessageDialog(null, "插入失败");
					}
				} else {
					// 若id存在
					JOptionPane.showMessageDialog(null, "此guid已存在，请重新输入");
				}
			}
		}
		// 修改用户
		if (o == jb_xiugai) {
			String VId = jt_bianhao.getText(); // 获取id
			String VName = jt_mingcheng.getText(); // 获取用户名
			if (VId.equals("")||VName.equals("")) {

				JOptionPane.showMessageDialog(null, "内容不能为空");
			}else {
			DanWei newuUser = new DanWei(Integer.parseInt(VId), VName);
			int count = daodsdDanwei.update(VId, VName);
			if (count > 0) {
				JOptionPane.showMessageDialog(null, "修改成功");
			} else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
			flash();

		}
		}
		if (o == jb_shanchu) {
			String VId = jt_bianhao.getText(); // 获取id
			int count = daodsdDanwei.shanchu(VId);
			if (count > 0) {
				JOptionPane.showMessageDialog(null, "删除成功");
			} else {
				JOptionPane.showMessageDialog(null, "删除失败");
			}
			flash();
		}

	}

	private void flash() {
		// TODO Auto-generated method stub
		for (int i = model.getRowCount() - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		list = daodsdDanwei.selectAll();
		for (int i = 0; i < list.size(); i++) {

			DanWei danwei = list.get(i);// 拿出一个danwei对象
			// 将列表中的bianhao,mingcheng组成一个对象数组
			String[] rowData = { String.valueOf(danwei.getGUId()), danwei.getGUName() };
			model.addRow(rowData);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = jta_danwei.getSelectedRow();

		String guid = jta_danwei.getValueAt(row, 0).toString();
		String guname = jta_danwei.getValueAt(row, 1).toString();

		// 通过id查询用户
		DanWei danwei = daodsdDanwei.selectById(guid);

		// 将四个数据放到右侧的控件中
		jt_bianhao.setText(guid);
		jt_mingcheng.setText(guname);
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

}
