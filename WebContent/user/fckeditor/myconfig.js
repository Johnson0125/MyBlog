//自定义工具栏
FCKConfig.ToolbarSets["myToolbar"] = [
	['Source','-','Preview','-','Templates'],
	['Cut','Copy','Paste','PasteText','PasteWord'],
	['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
	'/',
	['Bold','Italic','Underline','StrikeThrough','-','Subscript','Superscript'],
	['OrderedList','UnorderedList','-','Outdent','Indent','Blockquote','CreateDiv'],
	['JustifyLeft','JustifyCenter','JustifyRight','JustifyFull'],
	['Link','Unlink','Anchor'],
	['Image','Flash','Table','Rule','Smiley','SpecialChar','PageBreak'],
	'/',
	['Style','FontFormat','FontName','FontSize'],
	['TextColor','BGColor'],
	['FitWindow','ShowBlocks']		// No comma for the last row.
] ;
//自定义字体
FCKConfig.FontNames		= '宋体;黑体;方正舒体;方正姚体;仿宋;华文行楷;楷体;Arial;Comic Sans MS;Courier New;Tahoma;Times New Roman;Verdana' ;


FCKConfig.FontSizes		= '5px;6px;7px;8px;9px;10px;11px;12px;14px;16px;18px;20px;25px;30px;36px;48px' ;
//自定义表情图片存放地址
FCKConfig.SmileyPath	= FCKConfig.BasePath + 'images/smiley/baidu/' ;
FCKConfig.SmileyImages	= ['regular_smile.gif','sad_smile.gif','wink_smile.gif','teeth_smile.gif','confused_smile.gif','tounge_smile.gif','embaressed_smile.gif','omg_smile.gif','whatchutalkingabout_smile.gif','angry_smile.gif','angel_smile.gif','shades_smile.gif','devil_smile.gif','cry_smile.gif','lightbulb.gif','thumbs_down.gif','thumbs_up.gif','heart.gif','broken_heart.gif','kiss.gif','012.gif','013.gif','014.gif','009.jpg','qw_cat_0002.png','qw_cat_0003.png','qw_cat_0004.png','qw_cat_0005.png','qw_cat_0006.png','qw_cat_0007.png','qw_cat_0008.png','qw_cat_0009.png'] ;
FCKConfig.SmileyColumns = 4 ;
FCKConfig.SmileyWindowWidth		= 300 ;
FCKConfig.SmileyWindowHeight	= 130 ;