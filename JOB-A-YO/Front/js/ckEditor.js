/**
 * This configuration was generated using the CKEditor 5 Builder. You can modify it anytime using this link:
 * https://ckeditor.com/ckeditor-5/builder/?redirect=portal#installation/NoNgNARATAdA7DAHBSIRygVgMxQCwh55QCMcADIgJyKLkiZRSIWYjmnYlTkoQDWAexTkwwEmFFTJYEgF1IAMwCGIRJjiYIcoA===
 */

const {
	ClassicEditor,
	Autosave,
	Essentials,
	Paragraph,
	Bold,
	Italic,
	Underline,
	Strikethrough,
	FontBackgroundColor,
	FontColor,
	FontFamily,
	FontSize,
	ImageToolbar,
	ImageBlock,
	Link,
	Table,
	TableToolbar
} = window.CKEDITOR;

const LICENSE_KEY =
	'eyJhbGciOiJFUzI1NiJ9.eyJleHAiOjE3NjIxMjc5OTksImp0aSI6IjQ3Y2Y1YzdhLTAxMDAtNGFiMC04MTJmLWQxZjE0MzIwNzkzYiIsInVzYWdlRW5kcG9pbnQiOiJodHRwczovL3Byb3h5LWV2ZW50LmNrZWRpdG9yLmNvbSIsImRpc3RyaWJ1dGlvbkNoYW5uZWwiOlsiY2xvdWQiLCJkcnVwYWwiLCJzaCJdLCJ3aGl0ZUxhYmVsIjp0cnVlLCJsaWNlbnNlVHlwZSI6InRyaWFsIiwiZmVhdHVyZXMiOlsiKiJdLCJ2YyI6IjU3M2JhZDJkIn0.8wUPAefQxghcH5bSW9lXGIwyH6OkRDyXdSF93pxcxJc7vJqmmI3UXuzz5rMSOHRobNaz_Ko7WDPUzqzuZiEhtA';

const editorConfig = {
	toolbar: {
		items: [
			'undo',
			'redo',
			'|',
			'fontSize',
			'fontFamily',
			'fontColor',
			'fontBackgroundColor',
			'|',
			'bold',
			'italic',
			'underline',
			'strikethrough',
			'|',
			'link',
			'insertTable'
		],
		shouldNotGroupWhenFull: true
	},
	plugins: [
		Autosave,
		Bold,
		Essentials,
		FontBackgroundColor,
		FontColor,
		FontFamily,
		FontSize,
		ImageBlock,
		ImageToolbar,
		Italic,
		Link,
		Paragraph,
		Strikethrough,
		Table,
		TableToolbar,
		Underline
	],
	fontFamily: {
		supportAllValues: true
	},
	fontSize: {
		options: [10, 12, 14, 'default', 18, 20, 22],
		supportAllValues: true
	},
	image: {
		toolbar: []
	},
	language: 'ko',
	licenseKey: LICENSE_KEY,
	link: {
		addTargetToExternalLinks: true,
		defaultProtocol: 'https://',
		decorators: {
			toggleDownloadable: {
				mode: 'manual',
				label: 'Downloadable',
				attributes: {
					download: 'file'
				}
			}
		}
	},
	placeholder: 'Type or paste your content here!',
	table: {
		contentToolbar: ['tableColumn', 'tableRow', 'mergeTableCells']
	}
};

ClassicEditor.create(document.querySelector('#editor'), editorConfig)
	.then(editor => {
		editor.editing.view.change(writer => {
			writer.setStyle('min-height', '300px', editor.editing.view.document.getRoot());			
		});
	})
	.catch(error => {
		console.error(error);
	});
