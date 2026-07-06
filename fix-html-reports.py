#!/usr/bin/env python3
"""
Fix broken HTML img tags in ExtentReports after test execution.
Ensures all <img> tags are properly self-closed with />
"""

import os
import re
from pathlib import Path

def fix_img_tags(file_path):
    """Fix broken img tags in HTML file"""
    try:
        with open(file_path, 'r', encoding='utf-8') as f:
            content = f.read()
        
        original_content = content
        
        # Fix Pattern 1: <img ... >\s*</img> - Remove closing tags and ensure self-closing
        content = re.sub(r'<img\s+([^/>]*?)>\s*</img>', r'<img \1 />', content)
        
        # Fix Pattern 2: <img.*?> that are not already self-closed
        # Find all img tags and fix those without />
        def fix_img_tag(match):
            tag = match.group(0)
            # If already self-closed with />, leave it alone
            if tag.rstrip().endswith('/>'):
                return tag
            # Otherwise add space and /> before the >
            return tag.rstrip('>') + ' />'
        
        content = re.sub(r'<img\s+[^/>]*?>', fix_img_tag, content)
        
        # Write back if changed
        if content != original_content:
            with open(file_path, 'w', encoding='utf-8') as f:
                f.write(content)
            print(f"✅ Fixed: {file_path}")
            return True
        else:
            return False
    except Exception as e:
        print(f"❌ Error processing {file_path}: {e}")
        return False

def main():
    """Find and fix all HTML report files with broken img tags"""
    base_path = Path('/Users/aritra/eclipse-workspace/cucumberproject/target')
    
    fixed_count = 0
    
    # Find all HTML files in various report locations
    html_files = []
    
    # ExtentReports
    html_files.extend(base_path.glob('ExtentReports*/test-output/spark/*.html'))
    
    # Allure Reports
    html_files.extend(base_path.glob('site/allure-maven-plugin/**/*.html'))
    
    # TestNG Reports
    test_output = base_path / 'surefire-reports' / 'index.html'
    if test_output.exists():
        html_files.append(test_output)
    
    print(f"Found {len(html_files)} HTML report files to check")
    
    for html_file in html_files:
        if fix_img_tags(str(html_file)):
            fixed_count += 1
    
    print(f"\n✅ Total files fixed: {fixed_count}")

if __name__ == '__main__':
    main()
