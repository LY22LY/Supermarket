package SupermarketCashRegister;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.bean.Goodsutil1;

import com.bean.ShopVip;
import com.dao.DaoShopVip;
import com.dao.Goodsbank;
import com.bean.ShopVip1;

public class ShouYinJPanel extends JPanel implements ActionListener {
	private JPanel jp_shangpin;
	private JLabel jl_tiaoxingma;
	private JTextField jf_tiaoxingma;
	private JLabel jl_goumai;
	private JTextField jf_goumai;
	private JButton jb_goumai;

	private JPanel jp_jiezhang;
	private JLabel jl_kahao;
	private JTextField jf_kahao;
	private JLabel jl_xingming;
	private JTextField jf_xingming;
	private JLabel jl_jifen;
	private JTextField jf_jifen;
	private JLabel jl_yue;
	private JTextField jf_yue;
	private JLabel jl_gongji;
	private JLabel jl_zhaoling;
	private JTextField jt_lingyi;
	private JTextField jt_linger;
	private JLabel jl_shishou;
	private JTextField jf_shishou;
	private JButton jb_huiyuanjie;
	private JButton jb_xianjin;
	private JTable jt_goumai;
	private String Gid5;
	private String kucun5;
	private String shu5;
	private int row5;
	private DefaultTableModel model;
	private ArrayList<Goodsutil1> list;
	private ArrayList<ShopVip> vlist;
	private Goodsbank gs = new Goodsbank();
	private DaoShopVip daovip = new DaoShopVip();

	public ShouYinJPanel() {
		initGUI();
	}

	public void initGUI() {
		this.setPreferredSize(new Dimension(730, 500));
		// 边界布局
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);

		// 会员查询
		{
			jp_shangpin = new JPanel();
			jp_shangpin.setPreferredSize(new Dimension(725, 300));
			jp_shangpin.setLayout(null);
			// 设置边框
			jp_shangpin.setBorder(BorderFactory.createTitledBorder("商品购买"));

			// 放置商品条形码标签
			jl_tiaoxingma = new JLabel();
			jl_tiaoxingma.setText("商品条形码:");
			jl_tiaoxingma.setBounds(24, 25, 176, 20);
			jp_shangpin.add(jl_tiaoxingma);

			// 放置商品条形码文本框
			jf_tiaoxingma = new JTextField();
			jf_tiaoxingma.setBounds(130, 25, 200, 25);
			jp_shangpin.add(jf_tiaoxingma);

			// 放置购买标签
			jl_goumai = new JLabel();
			jl_goumai.setText("购买数量:");
			jl_goumai.setBounds(350, 25, 200, 20);
			jp_shangpin.add(jl_goumai);

			// 放置购买文本框
			jf_goumai = new JTextField();
			jf_goumai.setBounds(410, 25, 180, 25);
			jp_shangpin.add(jf_goumai);

			jb_goumai = new JButton("购买");
			jb_goumai.setBounds(610, 25, 60, 25);
			jb_goumai.addActionListener(this);
			jp_shangpin.add(jb_goumai);

			// 1.设置滚动面板
			JScrollPane jsp_goumao = new JScrollPane();
			jsp_goumao.setBounds(5, 55, 700, 220);
			jp_shangpin.add(jsp_goumao);

			model = new DefaultTableModel(null,
					new String[] { "商品条形码", "品名", "规格", "单位", "库存量", "会员价", "零售价", "数量", "金额" });// 两个参数，一个是内容数据（null），另一个是表头(在这里是个字符串数组)
			// 2.创建列表
			jt_goumai = new JTable(model);
			// 3.将列表放到滚动面板
			jsp_goumao.setViewportView(jt_goumai);

			this.add(jp_shangpin, BorderLayout.NORTH);
		}

		{
			jp_jiezhang = new JPanel();
			jp_jiezhang.setPreferredSize(new Dimension(725, 300));
			jp_jiezhang.setLayout(null);
			// 设置边框
			jp_jiezhang.setBorder(BorderFactory.createTitledBorder("结账"));

			// 放置会员卡号标签
			jl_kahao = new JLabel();
			jl_kahao.setText("会员卡号:");
			jl_kahao.setBounds(24, 25, 70, 20);
			jp_jiezhang.add(jl_kahao);

			// 放置会员卡号文本框
			jf_kahao = new JTextField();
			jf_kahao.setBounds(90, 25, 130, 25);
			jp_jiezhang.add(jf_kahao);

			// 放置姓名标签
			jl_xingming = new JLabel();
			jl_xingming.setText("姓名:");
			jl_xingming.setBounds(230, 25, 60, 20);
			jp_jiezhang.add(jl_xingming);

			// 放置姓名文本框
			jf_xingming = new JTextField();
			jf_xingming.setBounds(280, 25, 90, 23);
			jf_xingming.setBackground(getBackground());
			jf_xingming.setEditable(false);
			TitledBorder tb = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE));
			TitledBorder tb1 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE));
			tb.setTitleColor(Color.BLUE);
			tb1.setTitleColor(Color.WHITE);

			jf_xingming.setBorder(tb);
			jp_jiezhang.add(jf_xingming);





			// 放置积分标签
			jl_jifen = new JLabel();
			jl_jifen.setText("积分:");
			jl_jifen.setBounds(380, 25, 60, 20);
			jp_jiezhang.add(jl_jifen);

			// 放置积分文本框
			jf_jifen = new JTextField();
			jf_jifen.setBounds(430, 25, 90, 25);
			jf_jifen.setBackground(getBackground());
			jf_jifen.setEditable(false);
			jf_jifen.setBorder(tb);
			jp_jiezhang.add(jf_jifen);

			// 放置余额标签
			jl_yue = new JLabel();
			jl_yue.setText("余额:");
			jl_yue.setBounds(530, 25, 60, 20);
			jp_jiezhang.add(jl_yue);

			// 放置余额文本框
			jf_yue = new JTextField();
			jf_yue.setBounds(570, 25, 90, 25);
			jf_yue.setBackground(getBackground());
			jf_yue.setEditable(false);
			jf_yue.setBorder(tb);
			jp_jiezhang.add(jf_yue);

			// 放置共计标签
			jl_gongji = new JLabel();
			jl_gongji.setText("共计:  ￥ ");
			jl_gongji.setFont(new Font("微软雅黑", Font.CENTER_BASELINE, 15));
			jl_gongji.setBounds(24, 65, 70, 20);

			jt_lingyi = new JTextField();
			jt_lingyi.setBounds(100, 65, 90, 25);
			jt_lingyi.setBackground(getBackground());
			jt_lingyi.setText("0.00 ");
			jt_lingyi.setFont(new Font("微软雅黑", Font.CENTER_BASELINE, 15));
			jt_lingyi.setForeground(new Color(255, 0, 0));
			jt_lingyi.setBorder(tb1);
			jt_lingyi.setEditable(false);
			jp_jiezhang.add(jt_lingyi);
			jp_jiezhang.add(jl_gongji);

			// jl_lingyi=new JLabel();
			// jl_lingyi.setText("0.00 ");
			// jl_lingyi.setFont(new Font("微软雅黑", Font.CENTER_BASELINE, 15));
			// jl_lingyi.setForeground(new Color(255,0,0));
			// jl_lingyi.setBounds(100,65,60,20);
			// jp_jiezhang.add(jl_lingyi);

			// 放置实收标签
			jl_shishou = new JLabel();
			jl_shishou.setText("实收:  ￥");
			jl_shishou.setBounds(290, 65, 60, 20);
			jp_jiezhang.add(jl_shishou);

			// 放置实收文本框
			jf_shishou = new JTextField();
			jf_shishou.setBounds(365, 65, 130, 25);
			jp_jiezhang.add(jf_shishou);

			// 放置找零标签
			jl_zhaoling = new JLabel();
			jl_zhaoling.setText("找零:  ￥ ");
			jl_zhaoling.setBounds(24, 100, 70, 30);
			jl_zhaoling.setFont(new Font("微软雅黑", Font.CENTER_BASELINE, 15));
			jp_jiezhang.add(jl_zhaoling);

			jt_linger = new JTextField();
			jt_linger.setBounds(100, 105, 90, 25);
			jt_linger.setBackground(getBackground());
			jt_linger.setText("0.00 ");
			jt_linger.setFont(new Font("微软雅黑", Font.CENTER_BASELINE, 15));
			jt_linger.setForeground(new Color(255, 0, 0));
			jt_linger.setBorder(tb1);
			jt_linger.setEditable(false);
			jp_jiezhang.add(jt_linger);
			jp_jiezhang.add(jt_linger);

			// jl_linger=new JLabel();
			// jl_linger.setText("0.00 ");
			// jl_linger.setFont(new Font("微软雅黑", Font.CENTER_BASELINE, 15));
			// jl_linger.setForeground(new Color(255,0,0));
			// jl_linger.setBounds(100,105,50,20);
			// jp_jiezhang.add(jl_linger);

			jb_huiyuanjie = new JButton("会员卡结账");
			jb_huiyuanjie.setBounds(300, 103, 100, 25);
			jb_huiyuanjie.addActionListener(this);
			jp_jiezhang.add(jb_huiyuanjie);

			jb_xianjin = new JButton("现金结账");
			jb_xianjin.setBounds(430, 103, 100, 25);
			jb_xianjin.addActionListener(this);
			jp_jiezhang.add(jb_xianjin);

			this.add(jp_jiezhang, BorderLayout.CENTER);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();

		// 模糊查询
		if (o == jb_goumai) {

			String shuliang = jf_goumai.getText();
			if(shuliang == null || shuliang.equals("")  ) {
				JOptionPane.showMessageDialog(null, "请选择所购物品数量");

			}else {


				// 获取查询信息
				String info = jf_tiaoxingma.getText();

				// 如果info是空的，显示所有数据，如果不是空的，那就模糊查询
				if (info.equals("")) {
					JOptionPane.showMessageDialog(null, "没有您要查找的信息");
				} else {
					// 模糊查询

					// 查询全部用户数据
					list = gs.selectAll();

					list = gs.selectByName(info);

					if (list.size() == 0) {
						// 数据表中是空的
						JOptionPane.showMessageDialog(null, "没有您要查找的信息");
					}





					else {
						// 数据表不是空的，遍历集合，将数据拿出来，放到表格中
						for (int i = 0; i < list.size(); i++) {
							Goodsutil1 user = list.get(i); // 拿出一个user对象
							// 将要放到表格中的姓名、账号、角色拿出来，组织成一个对象数组
							double s = Double.parseDouble(user.getSaleprice());
							int n = Integer.parseInt(shuliang);
							double jine = s * n;

							String[] rowData = { user.getCid(), user.getName(), user.getGspec(), user.getGuid(),
									user.getGamount(), user.getVipprice(), user.getSaleprice(), shuliang,
									String.valueOf(jine) };

							model.addRow(rowData);

							double sum = 0;
							int row=model.getRowCount();

							for(int i1=0;i1<row;++i1) {
								String jine1 = model.getValueAt(i1, 8).toString();
								double j = Double.parseDouble(jine1);
								sum+=j;
							}
							jt_lingyi.setText(String.valueOf(sum));
							// model.addRow(row);
						}

					}

				}

			}
		}
		// user.getCid(),user.getName(), user.getGspec(),
		// user.getGuid(),user.getGamount(),user.getSaleprice(),user.getVipprice()

		if (o == jb_huiyuanjie) {

			vlist = gs.selectvAll();
			String info = jf_kahao.getText();

			if (info.equals("")) {
				JOptionPane.showMessageDialog(null, "没有您要查找的信息");
			} else {
				// 模糊查询
				// 查询全部用户数据
				vlist = gs.selectByid(info);
				if (vlist.size() == 0) {
					// 数据表中是空的
					JOptionPane.showMessageDialog(null, "没有您要查找的信息");
				} else {
					double a = 0;
					int rowCount = jt_goumai.getRowCount();
					for (int i = 0; i < rowCount; i++) {
						ShopVip user = vlist.get(i);
						a = Double.parseDouble(jt_lingyi.getText());
						String Gid5 = jt_goumai.getValueAt(i, 0).toString();
						String kucun5 = jt_goumai.getValueAt(i, 4).toString();
						String shu5 = jt_goumai.getValueAt(i, 7).toString();
						int newkucun = Integer.parseInt(kucun5) - Integer.parseInt(shu5);
						if (newkucun > 0) {
							ShopVip vip = gs.update1(user.getVId(), a);
							ShopVip newvip = daovip.selectById(vip.getVId());
							String jifen = String.valueOf(newvip.getConsumeScore());
							String yue = String.valueOf(newvip.getVBalance());
							jf_jifen.setText(jifen);
							jf_xingming.setText(newvip.getVName());
							jf_yue.setText(yue);
							gs.kucun(newkucun, Gid5);
						} else {
							JOptionPane.showMessageDialog(null, "库存不足");
						}
					}
				}
			}
			for (int i = model.getRowCount() - 1; i >= 0; i--) {
				model.removeRow(i);
			}

		}


		if (o == jb_xianjin) {

			String shishou = jf_shishou.getText();
			if (jt_lingyi.getText() == null || jt_lingyi.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "未购买商品");

			} else if (shishou == null || shishou.equals("")) {
				JOptionPane.showMessageDialog(null, "请输入实际收款余额");
			} else {

				double shi = Double.parseDouble(shishou);
				double zhao = shi - Double.parseDouble(jt_lingyi.getText());

				jt_linger.setText(String.valueOf(zhao));
				int rowCount = jt_goumai.getRowCount();
				for (int i = 0; i < rowCount; i++) {
					Gid5 = jt_goumai.getValueAt(i, 0).toString();

					kucun5 = jt_goumai.getValueAt(i, 4).toString();
					shu5 = jt_goumai.getValueAt(i, 7).toString();
					int newkucun = Integer.parseInt(kucun5) - Integer.parseInt(shu5);
					gs.kucun(newkucun, Gid5);
				}
				JOptionPane.showMessageDialog(null, "现金结账已成功");

			}
			for (int i = model.getRowCount() - 1; i >= 0; i--) {
				model.removeRow(i);
			}
			jt_lingyi.setText("");
		}
	}


}
